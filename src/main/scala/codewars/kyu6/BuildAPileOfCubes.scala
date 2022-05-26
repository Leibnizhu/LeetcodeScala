package codewars.kyu6

object BuildAPileOfCubes {
  /**
    * 立方和公式 1^3+2^3+...+n^3 = (n*(n+1))^2/4 = x
    * 反推 n = (sqrt(1+8*sqrt(x))-1)/2
    */
  def findNb(m: Long): Int = {
    val res = (math.sqrt(1 + 8 * math.sqrt(m)) - 1) / 2
    if (res.toInt - res == 0) res.toInt else -1
  }
}
