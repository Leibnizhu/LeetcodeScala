package leetcode.primary.array

import org.scalatest.funsuite.AnyFunSuite

class TwoSumTest extends AnyFunSuite {
  /**
    * 给定 nums = [2, 7, 11, 15], target = 9
    * 因为 nums[0] + nums[1] = 2 + 7 = 9
    * 所以返回 [0, 1]
    */
  test("nums = [2, 7, 11, 15], target = 9") {
    val nums = Array(2, 7, 11, 15)
    val result = TwoSum.twoSum(nums, 9)
    assert(result sameElements Array(0, 1))
  }

  test("nums = [2, 7, 11, 15], target = 4") {
    val nums = Array(2, 7, 11, 15)
    val result = TwoSum.twoSum(nums, 4)
    assert(result sameElements Array(0, 0))
  }

  test("nums = [2, 7, 11, 15], target = 30") {
    val nums = Array(2, 7, 11, 15)
    val result = TwoSum.twoSum(nums, 30)
    assert(result sameElements Array(3, 3))
  }

  test("nums = [3, 3], target = 6") {
    val nums = Array(3, 3)
    val result = TwoSum.twoSum(nums, 6)
    assert(result sameElements Array(0, 1))
  }

  test("nums = [3], target = 6") {
    val nums = Array(3)
    val result = TwoSum.twoSum(nums, 6)
    assert(result sameElements Array(0, 0))
  }

  test("nums = [3,2,4], target = 6") {
    val nums = Array(3, 2, 4)
    val result = TwoSum.twoSum(nums, 6)
    assert(result sameElements Array(1, 2))
  }
}
