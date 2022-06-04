package codewars.kyu4

import codewars.kyu4.GettingAlongWithIntegerPartitionsTest.dotest
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class GettingAlongWithIntegerPartitionsTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    dotest(1, "Range: 0 Average: 1.00 Median: 1.00")
    dotest(4, "Range: 3 Average: 2.50 Median: 2.50")
    dotest(6, "Range: 8 Average: 4.75 Median: 4.50")
  }
}

object GettingAlongWithIntegerPartitionsTest {
  private def dotest(n: Long, expect: String): Unit = {
    println("Testing: " + n)
    val actual: String = GettingAlongWithIntegerPartitions.part(n)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect){actual}
  }
}