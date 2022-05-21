package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class NRepeatedElementInSize2nArrayTest extends AnyFunSuite {
  test("case1") {
    assertResult(3)(NRepeatedElementInSize2nArray.repeatedNTimes(Array(1, 2, 3, 3)))
  }

  test("case2") {
    assertResult(2)(NRepeatedElementInSize2nArray.repeatedNTimes(Array(2, 1, 2, 5, 3, 2)))
  }

  test("case3") {
    assertResult(5)(NRepeatedElementInSize2nArray.repeatedNTimes(Array(5, 1, 5, 2, 5, 3, 5, 4)))
  }
}
