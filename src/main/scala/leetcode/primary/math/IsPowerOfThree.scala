package leetcode.primary.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/62/
  *
  * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
  */
object IsPowerOfThree {
  def isPowerOfThree(n: Int): Boolean = {
    (Math.log10(n) / Math.log10(3)) % 1 == 0
  }
}
