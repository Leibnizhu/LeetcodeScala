package leetcode.primary.dynamic

import org.scalatest.FunSuite

class MaxSubArrayTest extends FunSuite{
  /**
    * 输入: [-2,1,-3,4,-1,2,1,-5,4],
    * 输出: 6
    * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    */
  test("-2,1,-3,4,-1,2,1,-5,4"){
    assert(MaxSubArray.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)) == 6)
  }

  /**
    * 子数组最少包含一个元素
    */
  test("-2"){
    assert(MaxSubArray.maxSubArray(Array(-2)) == -2)
  }

  test("1"){
    assert(MaxSubArray.maxSubArray(Array(1)) == 1)
  }
}
