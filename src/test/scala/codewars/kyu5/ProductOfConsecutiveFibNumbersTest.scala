package codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec

class ProductOfConsecutiveFibNumbersTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    dotest(4895L, Array(55, 89, 1))
    dotest(5895L, Array(89, 144, 0))
    dotest(74049690L, Array(6765, 10946, 1))
  }

  def dotest(prod: Long, expect: Array[Long]): Unit = {
    println("Testing: " + prod)
    val actual: Array[Long] = ProductOfConsecutiveFibNumbers.productFib(prod)
    println("Actual: " + actual.mkString(", "))
    println("Expect: " + expect.mkString(", "))
    println("-")
    assertResult(expect) {
      actual
    }
  }
}