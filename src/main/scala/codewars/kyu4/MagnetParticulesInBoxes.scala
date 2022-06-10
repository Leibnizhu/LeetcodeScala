package codewars.kyu4

/**
  * 2022-06-10
  * {@see <a href='https://www.codewars.com/kata/56c04261c3fcf33f2d000534/train/scala'/> }
  */
object MagnetParticulesInBoxes {
  def doubles(maxk: Int, maxn: Int): Double = (for {
    k <- 1 to maxk
    n <- 1 to maxn
  } yield 1 / (k * (Math.pow(n + 1, 2 * k)))).sum
}
