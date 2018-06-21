package leetcode.medium.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/115/
  *
  * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
  * 说明:
  * -100.0 < x < 100.0
  * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
  */
object Power {
  /**
    * 由于测试用例里有n很大的,直接递归会栈溢出,改成迭代的话,会超时
    * 所以不能用O(n)的算法,要用O(log n),将n对半来算,奇数的话再乘一次
    */
  def myPow(x: Double, n: Int): Double = {
    if (n == 0)
      1
    else if (n == 1)
      x
    else if (n == -1)
      1 / x
    else {
      val tmp = myPow(x, n / 2)
      if (n % 2 == 0)
        tmp * tmp
      else if (n > 0)
        tmp * tmp * x
      else
        tmp * tmp / x
    }
  }
}
