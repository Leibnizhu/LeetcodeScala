package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/156/
  *
  * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
  */
object PerfectSquares {
  /**
    * 动态规划,跟凑硬币类似,状态转移方程是:
    * f(i) = min(1+f(i-1), 1+f(i-4), ... , 1+f(i-i内最大完全平方数k))
    */
  def numSquares(n: Int): Int = {
    val memo = Array.fill(n + 1)(n + 1) //备忘录,初始化为n+1这样保证在计算min的时候正确
    memo(0) = 0
    for {
      i <- 1 to n //遍历填充备忘录
      j <- 1 to Math.sqrt(i).intValue //遍历小于i的完全平方数
    } yield if (memo(i) > 1 + memo(i - j * j)) memo(i) = 1 + memo(i - j * j) //出现了比之前更优的解
    memo.last
  }
}
