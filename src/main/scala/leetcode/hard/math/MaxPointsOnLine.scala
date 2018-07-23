package leetcode.hard.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/165/
  *
  * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
  */
object MaxPointsOnLine {
  def maxPoints(points: Array[Point]): Int = {
    //拼接斜率的字符串,符号分子/分母(为了避免求Double不精确,同时解决无穷大判断等问题)
    def slope(p1: Point, p2: Point): String = {
      val numerator = p1.y - p2.y
      val denominator = p1.x - p2.x
      val numeratorAbs = Math.abs(numerator)
      val denominatorAbs = Math.abs(denominator)
      val gcd = GCD(numeratorAbs, denominatorAbs) //0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
      s"${sign(numerator, denominator)}${numeratorAbs / gcd}/${denominatorAbs / gcd}"
    }

    //辗转相除法求最大公因子
    def GCD(x: Int, y: Int): Int = if (y == 0) x else GCD(y, x % y)

    //求斜率符号
    def sign(x: Int, y: Int): String = if (x <= 0 && y <= 0 || x >= 0 && y >= 0) "+" else "-"

    //判断两个点是否相同
    def isSame(p1: Point, p2: Point): Boolean = p1.y == p2.y && p1.x == p2.x

    points.length match {
      case 0 => 0
      case 1 => 1
      case _ => (for (i <- points.indices) yield {
        val samePointCount = points.indices.count(j => isSame(points(i), points(j))) //与当前点相同的点个数
        val l = points.indices.filter(j => j != i && !isSame(points(i), points(j))).groupBy(j => slope(points(i), points(j)))
        if (l.isEmpty) List(samePointCount) else l.map(_._2.length + samePointCount)
      }).flatten match {
        case l if l.isEmpty => 0
        case l => l.max
      }
    }
  }
}

case class Point(var x: Int, var y: Int)
