package leetcode.daily

import scala.annotation.tailrec


/**
  * 2022-05-20
  * {@see <a href='https://leetcode.cn/problems/find-right-interval/'/> }
  */
object FindRightInterval {
  def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
    //Array([左区间值,原下标])
    val sortedLeftWithIndex = intervals.map(_(0)).zipWithIndex.sortBy(_._1)

    //二分查找
    @tailrec
    def binarySearch(l: Int, r: Int, target: Int, result: Int): Int = {
      if (l > r) {
        result
      } else {
        val mid = (l + r) / 2
        if (sortedLeftWithIndex(mid)._1 >= target) {
          binarySearch(l, mid - 1, target, sortedLeftWithIndex(mid)._2)
        } else {
          binarySearch(mid + 1, r, target, result)
        }
      }
    }

    intervals.map(r => binarySearch(0, intervals.length - 1, r(1), -1))
  }
}
