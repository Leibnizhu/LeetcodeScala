package codewars.kyu6

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/54da5a58ea159efa38000836/train/scala'/> }
  */
object FindTheOddInt {
  def findOdd(xs: Seq[Int]): Int = xs.groupBy(x => x).filter(_._2.size % 2 == 1).head._1
}
