package codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec

class WeightForWeightTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    testing("103 123 4444 99 2000", "2000 103 123 4444 99")
    testing("2000 10003 1234000 44444444 9999 11 11 22 123", "11 11 2000 10003 22 123 1234000 44444444 9999")
    testing("", "")
    testing("10003 1234000 44444444 9999 2000 123456789", "2000 10003 1234000 44444444 9999 123456789")
    testing("3 16 9 38 95 1131268 49455 347464 59544965313 496636983114762 85246814996697", "3 16 9 38 95 1131268 49455 347464 59544965313 496636983114762 85246814996697")
  }

  private def testing(s: String, expect: String): Unit = {
    println("Testing:\n" + s)
    val actual: String = WeightForWeight.orderWeight(s)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect) {
      actual
    }
  }
}