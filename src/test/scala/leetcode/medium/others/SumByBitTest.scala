package leetcode.medium.others

import org.scalatest.FunSuite

class SumByBitTest extends FunSuite {
  test("1,2") {
    assert(SumByBit.getSum(1, 2) == 3)
  }

  test("2,3") {
    assert(SumByBit.getSum(2, 3) == 5)
  }
}
