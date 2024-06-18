主要考察的是故障排查优化的能力，进程的CPU占用高，通常是某个线程在使用比较耗CPU的计算功能，需要将该线程查找出来

## 通过Linux 自带工具排查

---

* 通过ps获取到进行id
```
    ps –ef | grep tomcat
```    
        
* 拿到CPU占用较高的线程ID
```
    top -H -p 30027
    或者
    ps -mp pid -o THREAD,tid,time
```
*  转换线程ID

```
    printf "%x\n" 1852
```

* 通过jstack 获取到线程的堆栈信息

## 借助Arthas 进行排查
* 下载arthas 
```
    curl -O https://arthas.aliyun.com/arthas-boot.jar
    java -jar arthas-boot.jar ##需要和目标程序同一用户权限
```
* 通过thread 命令排查最忙的线程
```
    thread -n 3 -i 1000  ## 最耗CPU的三个
```
* 通过堆栈定位代码块
  ![](http://image.e65535.com/github/20240617110009.png)