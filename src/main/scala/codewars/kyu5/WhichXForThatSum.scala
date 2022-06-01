package codewars.kyu5

/**
  * 2022-05-31
  * {@see <a href='https://www.codewars.com/kata/5b1cd19fcd206af728000056/train/scala'/> }
  */
object WhichXForThatSum {
  /**
    * 易证 SUM(n*x**n)=x/(1-x)**2, n -> inf
    * x/(1-x)**2 = m 方程求解有
    * x= (2 * m + 1 + math.sqrt(4 * m + 1)) / 2 / m
    * 或
    * x= (2 * m + 1 - math.sqrt(4 * m + 1)) / 2 / m
    *
    * 结合 x =[0,1], m > 0， 只有后者满足
    */
  def solve(m: Double): Double = (2 * m + 1 - math.sqrt(4 * m + 1)) / 2 / m
}
