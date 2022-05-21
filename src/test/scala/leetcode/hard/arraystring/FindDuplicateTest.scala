package leetcode.hard.arraystring

import org.scalatest.funsuite.AnyFunSuite

class FindDuplicateTest extends AnyFunSuite{
  test("1,3,4,2,2"){
    assert(FindDuplicate.findDuplicate(Array(1,3,4,2,2)) == 2)
  }

  test("3,1,3,4,2"){
    assert(FindDuplicate.findDuplicate(Array(3,1,3,4,2)) == 3)
  }
}
