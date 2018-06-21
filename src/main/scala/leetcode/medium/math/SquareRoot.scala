package leetcode.medium.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/116/
  *
  * 实现 int sqrt(int x) 函数。
  * 计算并返回 x 的平方根，其中 x 是非负整数。
  * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
  */
object SquareRoot {
  /**
    * 牛顿法
    */
  def mySqrt(x: Int): Int = {
    var root:Long = x
    while (root * root > x)
      root = (root + x / root) / 2
    root.intValue
  }
}
