package leetcode.hard.arraystring

import org.scalatest.FunSuite

class FindDuplicateTest extends FunSuite{
  test("1,3,4,2,2"){
    assert(FindDuplicate.findDuplicate(Array(1,3,4,2,2)) == 2)
  }

  test("3,1,3,4,2"){
    assert(FindDuplicate.findDuplicate(Array(3,1,3,4,2)) == 3)
  }
}
