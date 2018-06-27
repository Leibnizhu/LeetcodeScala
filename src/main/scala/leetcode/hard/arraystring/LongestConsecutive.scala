package leetcode.hard.arraystring

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/129/
  *
  * 给定一个未排序的整数数组，找出最长连续序列的长度。
  * 要求算法的时间复杂度为 O(n)。
  */
object LongestConsecutive {
  /**
    * 最直接的想法是排序后遍历,需要的时间复杂度是O(n*logn),但题目要求O(n)
    * 可以用Hash,把所有数存进去之后(O(n)),遍历每个数找是否前后有对应的数,记录长度,
    * 同时维护一个最大长度,最后返回(本题只要求最大长度不要求具体的序列)
    */
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums == null)
      0
    else {
      val set = new mutable.HashSet[Int]()
      for (num <- nums) set += num
      var longest = 0

      def neighbor(len: Int, num: Int)(f: (Int, Int) => Int): Int = {
        if (set.contains(num)) {
          set -= num
          neighbor(len + 1, f(num, 1))(f)
        } else
          len
      }

      for (num <- nums) {
        var len = 1
        len = neighbor(len, num - 1)(_ - _)
        len = neighbor(len, num + 1)(_ + _)
        longest = Math.max(longest, len)
      }
      longest
    }
  }
}
