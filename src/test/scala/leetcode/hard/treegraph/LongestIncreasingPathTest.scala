package leetcode.hard.treegraph

import org.scalatest.FunSuite

class LongestIncreasingPathTest extends FunSuite {
  /**
    * 解释: 最长递增路径为 [1, 2, 6, 9]。
    */
  test("sample1") {
    assert(LongestIncreasingPath.longestIncreasingPath(Array(
      Array(9, 9, 4),
      Array(6, 6, 8),
      Array(2, 1, 1)
    )) == 4)
  }

  /**
    * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
    */
  test("sample2") {
    assert(LongestIncreasingPath.longestIncreasingPath(Array(
      Array(3, 4, 5),
      Array(3, 2, 6),
      Array(2, 2, 1)
    )) == 4)
  }

  test("all Empty") {
    assert(LongestIncreasingPath.longestIncreasingPath(Array[Array[Int]]()) == 0)
  }

  test("empty roe") {
    assert(LongestIncreasingPath.longestIncreasingPath(Array(Array[Int]())) == 0)
  }
}
