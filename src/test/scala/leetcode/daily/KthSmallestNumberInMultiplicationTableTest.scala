package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class KthSmallestNumberInMultiplicationTableTest extends AnyFunSuite {
  test("case1") {
    assertResult(3)(KthSmallestNumberInMultiplicationTable.findKthNumber(3, 3, 5))
  }

  test("case2") {
    assertResult(6)(KthSmallestNumberInMultiplicationTable.findKthNumber(2, 3, 6))
  }

}
