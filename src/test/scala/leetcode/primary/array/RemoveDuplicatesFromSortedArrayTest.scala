package leetcode.primary.array

import org.scalatest.FunSuite

class RemoveDuplicatesFromSortedArrayTest extends FunSuite {

  /**
    * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
    */
  test("[1,1,2]") {
    val nums = Array(1, 1, 2)
    val count = RemoveDuplicatesFromSortedArray.removeDuplicates(nums)
    assert(count == 2)
    assert(nums(0) == 1)
    assert(nums(1) == 2)
  }

  /**
    * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
    */
  test("[0,0,1,1,1,2,2,3,3,4]") {
    val nums = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val count = RemoveDuplicatesFromSortedArray.removeDuplicates(nums)
    assert(count == 5)
    assert(nums(0) == 0)
    assert(nums(1) == 1)
    assert(nums(2) == 2)
    assert(nums(3) == 3)
    assert(nums(4) == 4)
  }

  test("null") {
    val nums = null
    val count = RemoveDuplicatesFromSortedArray.removeDuplicates(nums)
    assert(count == 0)
  }

  test("[2]") {
    val nums = Array(2)
    val count = RemoveDuplicatesFromSortedArray.removeDuplicates(nums)
    assert(count == 1)
  }
}
