package leetcode.primary.array

import org.scalatest.FunSuite

class ContainsDuplicateTest extends FunSuite{
  test("[1,2,3,1]"){
    val nums = Array(1,2,3,1)
    val result = ContainsDuplicate.containsDuplicate(nums)
    assert(result)
  }

  test("[1,2,3,4]"){
    val nums = Array(1,2,3,4)
    val result = ContainsDuplicate.containsDuplicate(nums)
    assert(!result)
  }

  test("[1,1,1,3,3,4,3,2,4,2]"){
    val nums = Array(1,1,1,3,3,4,3,2,4,2)
    val result = ContainsDuplicate.containsDuplicate(nums)
    assert(result)
  }

  test("null"){
    val nums = null
    val result = ContainsDuplicate.containsDuplicate(nums)
    assert(!result)
  }
}
