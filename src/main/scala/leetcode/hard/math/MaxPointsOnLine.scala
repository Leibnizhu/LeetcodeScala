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
      val (numerator, denominator) = (points(p1).y - points(p2).y, points(p1).x - points(p2).x) //斜率分母分子
      val (numeratorAbs, denominatorAbs) = (Math.abs(numerator), Math.abs(denominator))
      val gcd = GCD(numeratorAbs, denominatorAbs) //gcd(0,x)=x,gcd(0,0)=0,斜率无穷时分母为0
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
        val otherPoints = points.indices.filter(!isSame(i, _)) //过滤所有与当前点不同的点
        val samePoints = points.length - otherPoints.length //与当前点相同的点个数
        if (otherPoints.isEmpty) List(samePoints) //若没有不同的点,则返回相同点个数,当前点同线点只有这些
        else otherPoints.groupBy(slope(i, _)).map(_._2.length + samePoints) //否则按斜率分组,取分组长度+相同点个数即同线点的数量
      }).flatten.max
    }
  }
}

class Point(var _x: Int, var _y: Int) {
  var x: Int = _x
  var y: Int = _y
}