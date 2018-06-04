package leetcode.primary.array

import org.scalatest.FunSuite

class RotateArrayTest extends FunSuite{
  /**
    * 向右旋转 1 步: [7,1,2,3,4,5,6]
    * 向右旋转 2 步: [6,7,1,2,3,4,5]
    * 向右旋转 3 步: [5,6,7,1,2,3,4]
    */
  test("[1,2,3,4,5,6,7]"){
    val nums = Array(1,2,3,4,5,6,7)
    RotateArray.rotate(nums, 3)
    assert(nums sameElements Array(5,6,7,1,2,3,4))
  }

  /**
    * 向右旋转 1 步: [99,-1,-100,3]
    * 向右旋转 2 步: [3,99,-1,-100]
    */
  test("[-1,-100,3,99]"){
    val nums = Array(-1,-100,3,99)
    RotateArray.rotate(nums, 2)
    assert(nums sameElements Array(3,99,-1,-100))
  }

  test("null"){
    val nums = null
    RotateArray.rotate(nums, 2)
    assert(nums == null)
  }

  test("[2]"){
    val nums = Array(2)
    RotateArray.rotate(nums, 5)
    assert(nums sameElements Array(2))
  }
}
