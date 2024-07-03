Mysql 作为一款强大的关系型数据库，有一个关键且基础的功能，就是必须保证数据的安全性。数据的安全性，指符合数据库的ACID特性，需要有保证事务的一致性，奔溃恢复等功能。
Mysql的innodb 则是通过binlog、redolog、undolog一整套日志体系，来提供数据安全性的技术支持

## 基本概念
### crash-safe

crash-safe 是MySQL的一个基础概念，指的是在Mysql服务器戎机重启后，需要保证：

- 所有已经提交的事务的数据仍然存在
- 所有没有提交的事务的数据自动回滚

### WAL机制

WAL机制（Write Ahead Log技术），也称日志先行技术，指的是为了保证数据一致性和持久性，提升语句执行性能，在对数据文件进行修改的时候，必须将修改先进行记录。这也是大部分存储系统采用的方案。

## 实现方案
Innodb 的数据安全，主要是通过Mysql的三个核心日志来实现的，redolog（重做日志）、undolog（回滚日志）、binlog（归档日志）。

*  redolog（Innodb 引擎级别的日志）：重做日志，又称事务日志，主要记录的是数据库中每个页的修改，而不是行级别的修改，用于恢复提交后的物理数据页（只能恢复最后的，恢复是采用的覆盖恢复）。其中redolog的大小事固定的，采用的是循环写入的模式，当日志写满的时候，是在保证擦除记录对应页落盘后进行对旧的日志进行擦除。查出的过程中，不接收新的数据，所以redolog 的日志大小需要考虑。
*  undolog（Innodb 引擎级别的日志）：回滚日志，主要用于事务的回滚、多版本控制等。在数据修改的时候，innodb会将当前操作的相反逻辑记录到undolog（insert 对应delete，update 对应相反的update），通过这个，来进行数据的回滚
*  binlog（Mysql Server级别的日志）：归档日志，由MySql server 层产生，主要记录用户对数据库的操作日志，用于数据库的恢复、同步等功能。


### 三大日志的配合流程

#### 写入流程
当用户对数据进行操作的时候，mysql 首先将事务提交给innodb ，有innodb 产生undo 日志和redo 日志，此时事务的状态属于prepare状态，当redo log返回perpare成功后，mysql 写入binlog日志，写入完成后，将事务状态转为commit状态，redolog日志写盘

为了保证数据的一致性，Mysql在binlog和redolog之间，采用2PC的方式，即二段式提交的方式。其中，mysql 作为二段式提交的是事务协调者，而binlog则是协调过程中的日志。2PC分为两个阶段：

1. Prepare 阶段：mysql 将事务提交给innodb，此时binlog不做任何操作，生成undo和redo 日志，并将redo日志写入到磁盘 
2. Commit 阶段：此时，innodb 返回prepare都执行成功了，协调者记录日志，即binlog。记录完成后，将commit状态告知innodb，此时会再次刷新redo日志的commit状态，将事务状态改为TRX_NOT_STARTED

#### 奔溃恢复阶段

1. 当数据提交在此事务的binlog写入之前，或者过程中，由于binlog并没有写入成功，那么，重启的时候会进行一轮回滚，主要是通过binlog回滚redolog，将无效的数据去除。这样子，binlog中就没有该事务，从库也不需要修改
2. 当数据提交在此事务的binlog之后，无论redo的状态如何，数据库都认定该事务已经完成，此时，innodb 会在redolog 写入commit状态，并且完成该事务的数据修改，提交事务

简单来说，当系统挂掉，redo log里面可能包含无效数据(待回滚数据)，当系统再恢复后，首先会去处理binlog，根据binlog会回滚redo log（处理完后，redo log的数据都是有效数据），最后才会读取redo log恢复 bufferpool。