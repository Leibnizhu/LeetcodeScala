package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/154/
  *
  * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
  */
object MaxProductSubArray {
  /**
    * 和初级的最大子序列和类似,把求和改成求乘积
    * 但乘法会负负得正,因此除了保存最大值,还要保存最小值(负数,遇到新的负数的时候,也要拿出来相乘评估新的最大值)
    */
  def maxProduct(nums: Array[Int]): Int = {
    var totalMax = Int.MinValue
    var curMax = 1
    var curMin = 1
    nums.foreach(num => {
      val tmp = curMax
      curMax = Math.max(Math.max(num, num * tmp), num * curMin)
      curMin = Math.min(Math.min(num, num * tmp), num * curMin)
      totalMax = Math.max(totalMax, curMax)
    })
    totalMax
  }
}
