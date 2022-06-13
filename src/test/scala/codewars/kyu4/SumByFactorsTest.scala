package codewars.kyu4

import codewars.kyu4.SumByFactorsTest.testing
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite

class SumByFactorsTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    var lst: Array[Int] = Array(12, 15)
    testing(lst, "(2 12)(3 27)(5 15)")
    lst = Array(15,21,24,30,45)
    testing(lst, "(2 54)(3 135)(5 90)(7 21)")
    testing(Array(107, 158, 204, 100, 118, 123, 126, 110, 116, 100),
      "(2 1032)(3 453)(5 310)(7 126)(11 110)(17 204)(29 116)(41 123)(59 118)(79 158)(107 107)")
    testing(Array(-29804, -4209, -28265, -72769, -31744),
      "(2 -61548)(3 -4209)(5 -28265)(23 -4209)(31 -31744)(53 -72769)(61 -4209)(1373 -72769)(5653 -28265)(7451 -29804)")
  }
}

object SumByFactorsTest {
  private def testing(lst: Array[Int], expect: String): Unit = {
    println("Testing: " + lst.mkString(" "))
    val actual: String = SumByFactors.sumOfDivided(lst)
    println("Actual: " + actual)
    println("Expect: " + expect)
    assertResult(expect){actual}
  }
}
