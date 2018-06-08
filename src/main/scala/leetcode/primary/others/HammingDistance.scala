package leetcode.primary.others

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/65/
  *
  * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
  * 给出两个整数 x 和 y，计算它们之间的汉明距离。
  * 注意：0 ≤ x, y < 231.
  */
object HammingDistance {
  /**
    * 异或之后算汉明重量即可
    */
  def hammingDistance(x: Int, y: Int): Int = {
    var n = x ^ y
    var weight = 0
    for (i <- 0 until 32) {
      weight += n & 1
      n = n >> 1
    }
    weight
  }
}
