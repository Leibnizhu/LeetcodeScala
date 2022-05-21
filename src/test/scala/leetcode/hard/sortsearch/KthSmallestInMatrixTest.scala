package leetcode.hard.sortsearch

import org.scalatest.funsuite.AnyFunSuite

class KthSmallestInMatrixTest extends AnyFunSuite {
  test("sample1") {
    assert(KthSmallestInMatrix.kthSmallest(Array(
      Array(1, 5, 9),
      Array(10, 11, 13),
      Array(12, 13, 15)
    ), 8) == 13)
  }

  test("sample2") {
    assert(KthSmallestInMatrix.kthSmallest(Array(
      Array(1, 2),
      Array(1, 3)
    ), 1) == 1)
  }
}
