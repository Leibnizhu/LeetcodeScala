package codewars.kyu3

import java.math.BigInteger
import java.math.BigInteger.{ONE, ZERO, valueOf}

/**
  * 2022-06-15
  * {@see <a href='https://www.codewars.com/kata/54cb771c9b30e8b5250011d4/train/scala'/> }
  */
object FabergeEasterEggsCrushTest {
  def height(n: BigInteger, m: BigInteger): BigInteger = if (m == ZERO || n == ZERO) ZERO else (1 to n.intValue())
    .foldLeft((ZERO, ONE))((res, i) => {
      val (curSum, prevCombine) = res
      val curCombine = prevCombine.multiply(m.subtract(valueOf(i - 1))).divide(valueOf(i))
      (curSum.add(curCombine), curCombine)
    })._1
}