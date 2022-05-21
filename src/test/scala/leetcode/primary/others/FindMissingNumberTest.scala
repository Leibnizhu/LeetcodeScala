package leetcode.primary.others

import org.scalatest.funsuite.AnyFunSuite

class FindMissingNumberTest extends AnyFunSuite{
  test("3,0,1"){
    assert(FindMissingNumber.missingNumber(Array(3,0,1)) == 2)
  }

  test("9,6,4,2,3,5,7,0,1"){
    assert(FindMissingNumber.missingNumber(Array(9,6,4,2,3,5,7,0,1)) == 8)
  }

  test("8,6,4,2,3,5,7,0,1"){
    assert(FindMissingNumber.missingNumber(Array(8,6,4,2,3,5,7,0,1)) == 9)
  }

  test("0"){
    assert(FindMissingNumber.missingNumber(Array(0)) == 1)
  }

  test("1"){
    assert(FindMissingNumber.missingNumber(Array(1)) == 0)
  }

  test("2,1"){
    assert(FindMissingNumber.missingNumber(Array(2,1)) == 0)
  }
}
