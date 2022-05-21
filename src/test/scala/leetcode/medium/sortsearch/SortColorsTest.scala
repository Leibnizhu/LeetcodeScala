package leetcode.medium.sortsearch

import org.scalatest.funsuite.AnyFunSuite

class SortColorsTest extends AnyFunSuite {
  test("2,0,2,1,1,0") {
    val nums = Array(2, 0, 2, 1, 1, 0)
    SortColors.sortColors(nums)
    assert(nums sameElements Array(0, 0, 1, 1, 2, 2))
  }

  test("2,0,1") {
    val nums = Array(2, 0, 1)
    SortColors.sortColors(nums)
    assert(nums sameElements Array(0, 1, 2))
  }
}