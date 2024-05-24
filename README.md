# code4work
努力工作，争取早日随心所欲的不工作

# 排序算法
- [x] 冒泡排序（Bubble Sort）[[BubbleSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/BubbleSort.java)]：通过重复遍历要排序的数列，比较每对相邻元素，如果顺序错误就交换它们。时间复杂度为 O(n^2)。
- [x] 选择排序（Selection Sort）[[SelectionSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/SelectionSort.java)]：从未排序序列中找到最小（或最大）的元素，存放到排序序列的起始位置，然后再从剩余未排序元素中继续寻找最小（或最大）元素，以此类推。时间复杂度为 O(n^2)。
- [x] 插入排序（Insertion Sort）[[InsertionSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/InsertionSort.java)]：构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。时间复杂度为 O(n^2)。
- [x] 归并排序（Merge Sort）[[MergeSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/MergeSort.java)]：采用分治法的一个非常典型的应用，将已有序的序列合并。时间复杂度为 O(n log n)。
- [x] 快速排序（Quick Sort）[[QuickSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/QuickSort.java)]：通过一个基准值将数据分为两部分，一部分数据比基准值小，另一部分数据比基准值大，再递归地排序这两部分数据。时间复杂度为 O(n log n)，但在最坏的情况下会退化到 O(n^2)。
- [x] 堆排序（Heap Sort）[[HeapSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/HeapSort.java)]：利用了二叉堆的数据结构，通过构建最大堆或最小堆，将堆顶元素与末尾元素交换，然后重新调整堆结构。时间复杂度为 O(n log n)。
- [x] 希尔排序（Shell Sort）[[ShellSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/ShellSort.java)]：是插入排序的一种更高效的改进版本，也使用分治策略，先将整个序列分为多个子序列，分别进行直接插入排序。时间复杂度介于 O(n) 和 O(n^2) 之间。
- [x] 计数排序（Counting Sort）[[CountingSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/CountingSort.java)]：不是基于比较的排序算法，适用于一定范围内的整数排序。时间复杂度为 O(n+k)，其中 k 是整数的范围。
- [x] 桶排序（Bucket Sort）[[BucketSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/BucketSort.java)]：将数组分派到有限数量的桶里，每个桶再分别排序。时间复杂度为 O(n+k)，其中 k 是桶的数量。
- [x] 基数排序（Radix Sort）[[RadixSort.java](src/main/java/com/luckycode/code4work/algorithm/sort/RadixSort.java)]：按照低位先排序，然后收集；再按照高位排序，然后再收集，以此类推，直到最高位。时间复杂度为 O(nk)，其中 k 是最大的数位数。可以看做是计数排序或者桶排序的扩展


# 场景解决方案
- [x] [消费订单过期的解决方案.md](note/消费订单过期的解决方案.md)
- [x] [重复提交问题解决方案.md](note/重复提交问题解决方案.md)
- [x] [唯一订单号生成方案.md](note/唯一订单号生成方案.md)
- [x] [核心热点数据更新如何保证准确性.md](note/核心热点数据更新如何保证准确性.md)

# 数据方案
- [x] [Vertica数据清理.md](note/Vertica数据清理.md)

# 生产排查
- [x] [记一次rsync的io问题排查.md](note/记一次rsync的io问题排查.md)
- [x] [JDK版本不同导致的SSL异常.md](note/JDK版本不同导致的SSL异常.md)

# 老八股
- [x] [Arraylist的foreach过程中不能删除元素的原因.md](note/Arraylist的foreach过程中不能删除元素的原因.md)

# 其他
- [x] [老旧项目基于cookie的多系统登录解决方案.md](note/老旧项目基于cookie的多系统登录解决方案.md)