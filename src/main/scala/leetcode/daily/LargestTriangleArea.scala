package leetcode.daily

/**
  * {@see <a href='https://leetcode.cn/problems/largest-triangle-area/'/> }
  */
object LargestTriangleArea {
  /**
    * 2022-05-15
    * 摆烂了，直接暴力法+鞋带公式
    */
  def largestTriangleArea(points: Array[Array[Int]]): Double = {
    val n = points.length
    (for {
      i <- 0 until n - 2
      j <- i + 1 until n - 1
      k <- j + 1 until n
    } yield {
      val x1 = points(i)(0)
      val y1 = points(i)(1)
      val x2 = points(j)(0)
      val y2 = points(j)(1)
      val x3 = points(k)(0)
      val y3 = points(k)(1)
      0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3)
    }).max
  }
}
