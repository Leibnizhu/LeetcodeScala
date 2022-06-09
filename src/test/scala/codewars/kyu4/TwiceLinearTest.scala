package codewars.kyu4

import codewars.kyu4.TwiceLinearTest.testing
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class TwiceLinearTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    testing(10, 22)
    testing(20, 57)
    testing(30, 91)
    testing(50, 175)
  }
}

object TwiceLinearTest {
  private def testing(n: Int, expect: Int): Unit = {
    println("Testing: " + n)
    val actual: Int = TwiceLinear.dblLinear(n)
    println("Actual: " + actual)
    println("Expect: " + expect)
    assertResult(expect) {
      actual
    }
  }
}