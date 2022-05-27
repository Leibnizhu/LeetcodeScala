package codewars.kyu4

/**
  * 2022-05-27
  * {@see <a href='https://www.codewars.com/kata/54eb33e5bc1a25440d000891/train/scala'/> }
  */
object SquareIntoSquares {
  def decompose(n: Long): String = {
    def rec(lessThan: Long, leftSum: Long, curNums: List[Long]):  List[Long] =
      if (leftSum == 0) //刚好用完
        curNums
      else if (leftSum < 0) //不能组装了
        List()
      else {
        for (i <- math.min(lessThan - 1, math.sqrt(leftSum).toInt) to 1 by -1) {
          val t = rec(i, leftSum - i * i, i :: curNums)
          if (t.nonEmpty) return t
        }
        List()
      }


    val res = rec(n, n * n, List())
    if (res.nonEmpty) res.mkString(" ") else null
  }
}
