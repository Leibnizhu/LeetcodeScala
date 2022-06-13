package codewars.kyu4


/**
  * 2022-06-13
  * {@see <a href='https://www.codewars.com/kata/54d496788776e49e6b00052f/train/scala'/> }
  */
object SumByFactors {
  def sumOfDivided(lst: Array[Int]): String = {
    def factors(k: Int): Set[Int] = {
      var (factors, d, n) = (new scala.collection.mutable.HashSet[Int](), 2, math.abs(k))
      while (d * d <= n) {
        while (n % d == 0) { //同个质因数出现多次
          factors += d
          n /= d
        }
        d += 1
      }
      if (n > 1) factors += n
      factors.toSet
    }

    lst.flatMap(n => factors(n).map(f => (f, n))).groupBy(_._1).toList.sortBy(_._1)
      .map(kv => s"(${kv._1} ${kv._2.map(_._2).sum})").mkString
  }
}
