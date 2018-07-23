package leetcode.hard.design

import scala.collection.mutable

/**
  * 1. 不排序,插入O(1),查询的话用之前的方法就是O(n)(类似快排,参考WiggleSort)
  * 2. 插入排序,那就插入O(n),查询O(1)(直接查中间的数)
  * 3. 也可以懒计算,就是插入不排序,维护一个标志识别当前数组是否排序,查询时排序(O(n*logn)对连续查询有优化)
  * 4. 二叉搜索树,节点增加子节点总数记录,插入O(logn),查询O(logn),最差情况严重不平衡时都是O(n)
  * 5. AVL平衡二叉树,插入O(logn),查询O(1),但实现比较麻烦
  * 6. 下面用的方法,维护一个最大堆和一个最小堆,保持两个堆大小一样,最大堆多一个数(这样直接拿堆顶的数就可以求中位数)
  *    插入时,如果总长度是奇数,则先插入最小堆,再从最小堆拿出堆顶放入最大堆;偶数时反之
  *    插入O(logn),查询O(1),实现比较简单,因为scala和java都有现成的最大堆实现
  */
class MedianFinder {
  /** initialize your data structure here. */
  var len = 0 //整体长度
  val leftMaxHeap = new mutable.PriorityQueue[Int]()
  val rightMixHeap = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  def addNum(num: Int) {
    len += 1
    if (len % 2 == 0) //长度为偶数,插入的数最终使最小堆增加一个数,所以插入到最大堆再取堆顶放入最小堆
      rightMixHeap += (leftMaxHeap += num).dequeue()
    else //长度为奇,插入的数最终使最大堆增加一个数
      leftMaxHeap += (rightMixHeap += num).dequeue()
  }

  def findMedian(): Double =
    if (len % 2 == 0)
      (leftMaxHeap.head + rightMixHeap.head) / 2.0
    else
      leftMaxHeap.head
}
