package codewars.kyu5

import codewars.kyu5.WhichXForThatSumTest.assertFuzzy
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class WhichXForThatSumTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assertFuzzy(2.00, 5.000000000000e-01)
    assertFuzzy(4.00, 6.096117967978e-01)
    assertFuzzy(5.00, 6.417424305044e-01)
  }
}

object WhichXForThatSumTest {
  private def assertFuzzy(m: Double, expect: Double): Unit = {
    val merr: Double = 1e-12
    println("Testing " + m)
    val actual: Double = WhichXForThatSum.solve(m)
    println("Actual: " + actual)
    println("Expect: " + expect)
    val inrange: Boolean = Math.abs(actual - expect) <= merr
    if (inrange == false) {
      println("Expected must be near " + expect + ", got " + actual)
    }
    println("-")
    assertResult(true) {
      inrange
    }
  }
}
