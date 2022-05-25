package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class UniqueSubstringsInWraparoundStringTest extends AnyFunSuite {
  test("case1") {
    assertResult(1)(UniqueSubstringsInWraparoundString.findSubstringInWraproundString("a"))
  }

  test("case2") {
    assertResult(2)(UniqueSubstringsInWraparoundString.findSubstringInWraproundString("cac"))
  }

  test("case3") {
    assertResult(6)(UniqueSubstringsInWraparoundString.findSubstringInWraproundString("zab"))
  }

}
