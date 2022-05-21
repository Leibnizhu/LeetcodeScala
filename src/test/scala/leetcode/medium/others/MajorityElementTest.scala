package leetcode.medium.others

import org.scalatest.funsuite.AnyFunSuite

class MajorityElementTest extends AnyFunSuite {
  test("3,2,3") {
    assert(MajorityElement.majorityElement(Array(3, 2, 3)) == 3)
  }

  test("2,2,1,1,1,2,2") {
    assert(MajorityElement.majorityElement(Array(2,2,1,1,1,2,2)) == 2)
  }
}
