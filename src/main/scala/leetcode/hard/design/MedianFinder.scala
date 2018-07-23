package leetcode.hard.design

import scala.collection.mutable

class MedianFinder {
  /** initialize your data structure here. */
  var len = 0 //整体长度
  val leftMaxHeap = new mutable.PriorityQueue[Int]()
  val rightMixHeap = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  def addNum(num: Int) {
    len += 1
    if (len % 2 == 0)
      rightMixHeap += (leftMaxHeap += num).dequeue()
    else
      leftMaxHeap += (rightMixHeap += num).dequeue()
  }

  def findMedian(): Double =
    if (len % 2 == 0)
      (leftMaxHeap.head + rightMixHeap.head) / 2.0
    else
      leftMaxHeap.head
}
