package codewars.kyu5

import codewars.kyu5.KPrimesTest.testing
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class KPrimesTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    testing(KPrimes.countKprimes(2, 0, 100),
      "4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95")
    testing(KPrimes.countKprimes(12, 100000, 100100), "")
    testing(KPrimes.countKprimes(1, 2, 30), "2, 3, 5, 7, 11, 13, 17, 19, 23, 29")
    testing(KPrimes.countKprimes(8, 10000000, 10000200), "10000096, 10000152, 10000165, 10000200")
  }
}

object KPrimesTest {
  private def testing(act: String, exp: String): Unit = {
    assertResult(exp) {
      act
    }
  }
}