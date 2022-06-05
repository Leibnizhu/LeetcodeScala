package codewars.kyu3

/**
  * 2022-06-05
  * {@see <a href='https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/train/scala'/> }
  */
object TheMillionthFibonacciKata {
  def fib(n: Int): BigInt = {
    if (n == 0 || n == 1) {
      return BigInt(n)
    } else if (n >= 2 && n % 2 == 0) {
      val k = n / 2
      val fk = fib(k)
      (2 * fib(k - 1) + fk) * fk
    } else if (n >= 2) {
      val k = (n + 1) / 2
      val fk1 = fib(k - 1)
      val fk2 = fib(k)
      fk2 * fk2 + fk1 * fk1
    } else {
      var (a, b) = (BigInt(0), BigInt(1))
      for (i <- 0 until n by -1) {
        a = b - a
        b = b - a
      }
      a
    }
  }
}
