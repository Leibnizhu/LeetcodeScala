package codewars.kyu3

import java.util.regex.Pattern

/**
  * 2022-05-30
  * {@see <a href='https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b/train/scala'/> }
  * random的test case 有问题，给的答案没处理溢出
  */
object BinomialExpansion {
  private val binExpPattern = Pattern.compile("\\((-?\\d*)(\\w)([+-]\\d+)\\)\\^(\\d+)")
  private val p0 = BigInt(0)
  private val p1 = BigInt(1)
  private val n1 = BigInt(-1)

  /**
    * 二项式公式
    * (a+b)ⁿ=C(n,0)aⁿ+C(n,1)aⁿֿ¹b+C(n,2)aⁿֿ²b²+.+C(n,(n-k))[a^(n-k)]b^k+......+C(n,n)bⁿ
    * 则
    * (ax+b)^n=C(n,0)*a^n*x^n + C(n,1)*a^(n-1)*x^(n-1)*b +.....+ C(n,n)*b^n
    */
  def expand(expr: String): String = {
    val matcher = binExpPattern.matcher(expr)
    if (!matcher.find()) "" else {
      val g1 = matcher.group(1)
      val a = if (g1 == null || g1.isEmpty) 1 else if (g1 == "-") -1 else g1.toInt
      val x = matcher.group(2)
      val b = matcher.group(3).toInt
      val n = matcher.group(4).toInt
      (n to 0 by -1).map(i => { //倒序，简化下面代码
        val c = combine(n, i) * BigInt(math.pow(a, i).toLong) * BigInt(math.pow(b, n - i).toLong) //系数
        val xStr = i match { //x项， i次幂
          case 0 => ""
          case 1 => x
          case _ => s"$x^$i"
        }
        c match {
          case `p0` => null
          case `p1` => if (xStr.isEmpty) "1" else xStr
          case `n1` => if (xStr.isEmpty) "-1" else s"-$xStr"
          case _ => s"$c$xStr"
        }
      }).filter(_ != null).mkString("+").replace("+-", "-")
    }
  }

  /**
    * 组合 C(n,m)
    * =(n*(n-1)*....*(n-m+1))/(m*(m-1)*...*1)
    */
  def combine(n: Int, m: Int): BigInt =
    (0 until m).foldLeft(BigInt(1))((r, i) => r * (n - i) / (i + 1))
}
