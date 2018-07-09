package leetcode.hard.treegraph

import java.util

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/145/
  *
  * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
  * 示例:
  * 输入: [5,2,6,1]
  * 输出: [2,1,1,0]
  */
object RightSmallerCount {
  /**
    * 暴力法最简单的,但显然需要O(n*n)时间,估计会提示超时
    * 要找右边更少的,那么右边的数是重复计算的,因此可以反过来从右边开始
    * 要知道右边有多少个小于当前数,可以维护一个数组保存右边的元素,已升序排序,
    * 则二分查找用O(log n)时间可以找到当前元素应该在的位置,即可知道有多少小于当前元素的
    * 当前元素同时可以插入到应该在的位置,因此耗时O(n*log n)
    */
  def countSmaller(nums: Array[Int]): List[Int] = {
    if (nums.isEmpty) {
      List()
    } else {
      val result = new Array[Int](nums.length)
      val sorted = new util.ArrayList[Int]()
      var (l, r) = (0, 0)
      for (i <- nums.length - 1 to 0 by -1) {
        l = 0
        r = sorted.size() //左右游标
        while (l < r) {
          val mid = l + (r - l) / 2
          if (sorted.get(mid) >= nums(i)) { //要找到第一个小于nums(i)的值的下标
            r = mid
          } else {
            l = mid + 1
          }
        }
        result(i) = l
        sorted.add(l, nums(i))
      }
      result.toList
    }
  }
}
