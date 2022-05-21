package leetcode.primary.array

import org.scalatest.funsuite.AnyFunSuite

class SingleNumberTest  extends AnyFunSuite{
  test("[2,2,1]"){
    val nums = Array(2,2,1)
    val result = SingleNumber.singleNumber(nums)
    assert(result == 1)
  }

  test("[4,1,2,1,2]"){
    val nums = Array(4,1,2,1,2)
    val result = SingleNumber.singleNumber(nums)
    assert(result == 4)
  }

  test("[2]"){
    val nums = Array(2)
    val result = SingleNumber.singleNumber(nums)
    assert(result == 2)
  }
}
