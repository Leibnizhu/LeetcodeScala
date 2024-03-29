package leetcode.hard.sortsearch

import scala.annotation.tailrec

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/153/
  *
  * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
  * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
  */
object SortedArrayMedian {
  /**
    * 对数复杂度,已排序,显然要用二分查找.这里难点是在两个数组里面二分查找一个数,让他在两边下标相加=总长度一半(中位数)
    * 当然还要把总长度奇数和偶数的情况分开考虑,我们只要给出一个找指定位置k的函数就行.
    * 二分查找的时候,我们在一个数组里取ia个,那么在另一个数组就要取ib=k-ia个
    */
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    /**
      * 在已排序的a(下标范围[as,length-1])和b(下标范围[bs,length-1])查找如果合并后排在第k位置的数
      */
    @tailrec
    def findKth(a: Array[Int], as: Int)(b: Array[Int], bs: Int)(k: Int): Int = {
      val la = a.length - as //当前a的长度
      val lb = b.length - bs //当前b的长度
      if (la == 0) { //短的一方长度为零了,要找的数必然在另一方,直接取即可
        b(k - 1)
      } else if (lb == 0) {
        a(k - 1)
      } else if (k == 1) { //找第一个,合并后必然是两方第一个元素较小者
        Math.min(a(as), b(bs))
      } else {
        var ia = Math.min(la, k >> 1) //本次迭代在a数组取多少个元素,最多只能取全部或k/2
        var ib = Math.min(lb, k >> 1) //本次迭代在b数组取多少个元素
        if (la > lb) ia = k - ib else ib = k - ia
        a(as + ia - 1) - b(bs + ib - 1) match {
          case d if d < 0 => findKth(a, as + ia)(b, bs)(k - ia) //a的数更小,说明a要往右边找才行
          case d if d > 0 => findKth(a, as)(b, bs + ib)(k - ib) //b的数更小,b要往右边找
          case _ => a(as + ia - 1)
        }
      }
    }

    val (m, n) = (nums1.length, nums2.length)
    val total = m + n
    if (total % 2 == 1) //奇数长度,取正中间的数
      findKth(nums1, 0)(nums2, 0)((total + 1) / 2)
    else //偶数长度,取中间两个数平均值
      (findKth(nums1, 0)(nums2, 0)(total / 2) +
        findKth(nums1, 0)(nums2, 0)(total / 2 + 1)) / 2.0 //这里其实可以用前面的结果减少计算,可是边界条件控制起来比较麻烦,而且又要一个二分比较麻烦,还是直接调用findKth好了
  }
}
