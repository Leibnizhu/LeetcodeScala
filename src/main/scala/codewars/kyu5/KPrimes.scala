package codewars.kyu5

/**
  * 2022-05-29
  * {@see <a href='https://www.codewars.com/kata/5726f813c8dcebf5ed000a6b/train/scala'/> }
  */
object KPrimes {
  def primeNum(k: Long): Int = {
    var (primeNum, d, n) = (0, 2, k)
    while (d * d <= n) {
      while (n % d == 0) { //同个质因数出现多次
        primeNum += 1
        n /= d
      }
      d += 1
    }
    if (n > 1) primeNum + 1 else primeNum //除剩的数非1即另一个质因数，要+1
  }

  def countKprimes(k: Int, start: Long, nd: Long): String = {
    (start to nd).filter(primeNum(_) == k).mkString(", ")
  }

  def puzzle(s: Int): Int = {
    val p1 = (0 to s).filter(primeNum(_) == 1)
    val p3 = (0 to s).filter(primeNum(_) == 3)
    val p7 = (0 to s).filter(primeNum(_) == 7)
    var res = 0
    for {
      v1 <- p1
      v3 <- p3
      v7 <- p7
    } yield if ((v1 + v3 + v7) == s) {
      res += 1
    }
    res
  }
}
