package leetcode.primary.array

import org.scalatest.FunSuite

class PlusOneTest extends FunSuite{
  test("[1,2,3]"){
    val nums = Array(1,2,3)
    val result = PlusOne.plusOne(nums)
    assert(result sameElements Array(1,2,4))
  }

  test("[4,3,2,1]"){
    val nums = Array(4,3,2,1)
    val result = PlusOne.plusOne(nums)
    assert(result sameElements Array(4,3,2,2))
  }

  test("[4,3,2,9]"){
    val nums = Array(4,3,2,9)
    val result = PlusOne.plusOne(nums)
    assert(result sameElements Array(4,3,3,0))
  }

  test("[9]"){
    val nums = Array(9)
    val result = PlusOne.plusOne(nums)
    assert(result sameElements Array(1,0))
  }
}
