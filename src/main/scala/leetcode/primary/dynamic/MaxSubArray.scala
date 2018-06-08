package leetcode.primary.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
  *
  * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
  * 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
  */
object MaxSubArray {
  /**
    * 考虑每一个元素,要生成最大的子串,要么加入前面的子串,要么自己新开一个
    * 前面的子串如果总和小于0,那么没必要加了,加了之后比自己单独开子串肯定要小
    * 因此动态规划可以用两个变量,分别保存总的最大子串和,以及前面子串和
    * 遍历的时候,如果前面子串和小于0,那么单独开开串,前子串和为当前值
    *          否则,加入前子串,前子串和加上当前值;
    *          实际上操作的时候,不关系加不加入前子串,我们只要维护当前子串和即可,
    *          即 前子串和'=max(当前值,当前值+前子串和),前子串和小于0 则新子串只包含当前值
    * 同时维护全局最大子串和(因为新开子串可能错过了前面的最大子串和了,要保存起来)
    */
  def maxSubArray(nums: Array[Int]): Int = {
    var totalMax = Int.MinValue
    var curMax = 0
    nums.foreach(num => {
      curMax = Math.max(num, num+curMax)
      totalMax = Math.max(totalMax, curMax)
//      println(s"$num\t$curMax\t$totalMax")
    })
    totalMax
  }
}
