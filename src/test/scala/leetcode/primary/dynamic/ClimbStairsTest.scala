package leetcode.primary.dynamic

import org.scalatest.funsuite.AnyFunSuite

class ClimbStairsTest extends AnyFunSuite{
  test("1"){
    assert(ClimbStairs.climbStairs(1) == 1)
  }

  test("2"){
    assert(ClimbStairs.climbStairs(2) == 2)
  }

  test("3"){
    assert(ClimbStairs.climbStairs(3) == 3)
  }

  test("4"){
    assert(ClimbStairs.climbStairs(4) == 5)
  }

  test("5"){
    assert(ClimbStairs.climbStairs(5) == 8)
  }
}
