package leetcode.medium.dynamic

import org.scalatest.funsuite.AnyFunSuite

class UniquePathsTest extends AnyFunSuite {
  test("3,2") {
    assert(UniquePaths.uniquePaths(3, 2) == 3)
  }

  test("2,3") {
    assert(UniquePaths.uniquePaths(2, 3) == 3)
  }

  test("7,3") {
    assert(UniquePaths.uniquePaths(7, 3) == 28)
  }

  test("3,7") {
    assert(UniquePaths.uniquePaths(3, 7) == 28)
  }

  test("1,90") {
    assert(UniquePaths.uniquePaths(1, 90) == 1)
  }

  test("90,1") {
    assert(UniquePaths.uniquePaths(90, 1) == 1)
  }
}
