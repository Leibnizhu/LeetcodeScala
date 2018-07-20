package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/159/
  *
  * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
  * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
  * 求所能获得硬币的最大数量。
  * 说明:
  *  - 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
  *  - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
  */
object PokeBalloon {
  /**
    * 动态规划,用f(i)(j)表示nums从i到j的子数组(不包含i,j)能戳到的最大coin数
    * f(l)(r) = max( f(l)(k) + f(k)(r) + nums(l)*nums(k)*nums(r) ), ∀ k∈(l,r)代表最后戳气球k
    * 拿到得分包括三部分:k左边子数组分数+k右边子数组分数+l*k*r分数
    * 为了保证两头的计算可行, 应该在数组前后增加1
    */
  def maxCoins(nums: Array[Int]): Int = {
    val vNums = (1 :: nums.toList) :+ 1
    val n = vNums.length //v=virtual 虚拟的气球数组
    val f = Array.ofDim[Int](n, n)
    for {
      len <- 3 to n //求解的子数组长度,必须先计算最小长度(3)的,因为更长的区间结果依赖更短的区间结果
      l <- 0 to n - len //子数组左下标
      r = l + len - 1 //子数组右下标
      k <- l + 1 until r //当前(l,r)区间最后一个戳的气球下标
    } {
      f(l)(r) = Math.max(f(l)(r), f(l)(k) + f(k)(r) + vNums(l) * vNums(k) * vNums(r))
    }

    f(0)(n - 1)
  }
}
