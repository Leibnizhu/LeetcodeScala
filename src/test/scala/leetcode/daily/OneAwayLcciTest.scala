package leetcode.daily

import org.scalatest.FunSuite

class OneAwayLcciTest extends FunSuite {
  test("case1") {
    assert(OneAwayLcci.oneEditAway("pale", "ple"))
  }

  test("case2") {
    assert(!OneAwayLcci.oneEditAway("pales", "pal"))
  }

  test("case3") {
    assert(OneAwayLcci.oneEditAway("pales", "palas"))
  }

  test("case4") {
    assert(!OneAwayLcci.oneEditAway("pales", "palae"))
  }

  test("case5") {
    assert(!OneAwayLcci.oneEditAway("pal", "palae"))
  }
}
