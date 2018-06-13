package leetcode.medium.treegraph

import org.scalatest.FunSuite

class NumberOfIslandsTest extends FunSuite {
  test("sample 1") {
    assert(NumberOfIslands.numIslands(Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )) == 1)
  }

  test("sample 2") {
    assert(NumberOfIslands.numIslands(Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '1', '0', '0'),
      Array('0', '0', '0', '1', '1')
    )) == 3)
  }

  test("empty 1") {
    assert(NumberOfIslands.numIslands(Array()) == 0)
  }

  test("empty 2") {
    assert(NumberOfIslands.numIslands(Array(Array())) == 0)
  }
}
