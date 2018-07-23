package leetcode.hard.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/164/
  *
  * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
  * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
  */
object LargestNumber {
  /**
    * 直接按拼接在一起的结果更大的顺序排序,然后合并成字符串即可
    * 要处理一下全是0的情况
    */
  def largestNumber(nums: Array[Int]): String =
    if (nums.forall(_ == 0)) "0" else
      nums.map(_.toString).sortWith((l, r) => (l + r).compareTo(r + l) >= 0).foldLeft("")(_ + _)
}
