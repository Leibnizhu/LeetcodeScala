package leetcode.hard.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/165/
  *
  * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
  */
object MaxPointsOnLine {
  /**
    * 暴力法,对每个点,求他和其他点构成连线的斜率,并对此统计每个斜率出现的频率的最大值,就是改点所在直线会出现最多点数
    * 遍历每个点这样求一遍之后, 整体的最大值就是题解
    * 时间复杂度O(n*n)
    */
  def maxPoints(points: Array[Point]): Int = {
    //拼接斜率的字符串,符号分子/分母(为了避免求Double不精确,同时解决无穷大判断等问题)
    def slope(p1: Int, p2: Int): String = {
      val numerator = points(p1).y - points(p2).y
      val denominator = points(p1).x - points(p2).x
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
    def isSame(p1: Int, p2: Int): Boolean = points(p1).y == points(p2).y && points(p1).x == points(p2).x

    points.length match {
      case 0 => 0 //特殊情况,无点,共线的点数为0
      case 1 => 1 //特殊情况,1个点,共线的点数为1
      case _ => (for (i <- points.indices) yield {
        val samePointCount = points.indices.count(j => isSame(i, j)) //与当前点相同的点个数
        val slopeFreq = points.indices.filter(j => j != i && !isSame(i, j)).groupBy(j => slope(i, j)) //当前点连线斜率频次
        if (slopeFreq.isEmpty) List(samePointCount) else slopeFreq.map(_._2.length + samePointCount) //若没有不同的点返回相同点个数
      }).flatten match {
        case l if l.isEmpty => 0
        case l => l.max
      }
    }
  }
}

class Point(var _x: Int, var _y: Int) {
  var x: Int = _x
  var y: Int = _y
}