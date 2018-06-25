package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/123/
  *
  * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
  * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
  * 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
  */
object ProductOfArrayExceptSelf {
  /**
    * 排列一下结果数组每个元素的来计算方法,其实是:
    *      x2 * x3 *...* xn
    * x1 *      x3 *...* xn
    * x1 * x2      x4..* xn
    * ......
    * x1 * x2 *...*xn-1
    * 要O(n)的话,把对角线两边分别当做两个数组遍历求出来(O(n),左边第一个元素和右边最后一个元素为1),再遍历一次相乘输出结果即可.
    * 但是进阶要求常数空间复杂度,又特别说明了输出数组不为额外空间
    * 因此考虑把其中一个数组作为输出的对象,另一个数组由于是不断相乘的,用一个数记录当前乘法结果即可(常数空间复杂度)
    */
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val left = new Array[Int](nums.length)
    left(0) = 1
    for (i <- 1 until nums.length) left(i) = left(i - 1) * nums(i - 1)
    var right = 1
    for (i <- nums.length - 1 to 0 by -1) {
      left(i) *= right
      right *= nums(i)
    }
    left
  }
}
