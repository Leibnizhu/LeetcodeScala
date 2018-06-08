package leetcode.primary.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
  *
  * 统计所有小于非负整数 n 的质数的数量。
  */
object CountPrimes {
  /**
    * 线性筛选法, 时间空间均O(n)
    */
  def countPrimes(n: Int): Int = {
    val origin = (2 until n).toArray //存储质数,计算结束后,非质数会放-1
    for (i <- 0 until n - 2) {
      val cur = origin(i)
      if (cur > 0) {
        var p = i + cur
        while (p < n - 2) {
          origin(p) = -1
          p += cur
        }
      }
    }
    origin.count(_ > 0)
  }
}
