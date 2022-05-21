package leetcode.primary.dynamic

import org.scalatest.funsuite.AnyFunSuite

class RobTest extends AnyFunSuite {
  /**
    * 输入: [1,2,3,1]
    * 输出: 4
    * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    * 偷窃到的最高金额 = 1 + 3 = 4 。
    */
  test("1,2,3,1") {
    assert(Rob.rob(Array(1, 2, 3, 1)) == 4)
  }

  /**
    * 输入: [2,7,9,3,1]
    * 输出: 12
    * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
    */
  test("2,7,9,3,1") {
    assert(Rob.rob(Array(2, 7, 9, 3, 1)) == 12)
  }

  test("empty") {
    assert(Rob.rob(Array[Int]()) == 0)
  }

  test("1,1") {
    assert(Rob.rob(Array(1,1)) == 1)
  }

  test("3") {
    assert(Rob.rob(Array(3)) == 3)
  }
}
