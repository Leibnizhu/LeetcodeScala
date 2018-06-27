package leetcode.hard.arraystring

import org.scalatest.FunSuite

class LongestConsecutiveTest extends FunSuite {
  test("null") {
    assert(LongestConsecutive.longestConsecutive(null) == 0)
  }

  test("empty") {
    assert(LongestConsecutive.longestConsecutive(Array()) == 0)
  }

  test("100, 4, 200, 1, 3, 2") {
    assert(LongestConsecutive.longestConsecutive(Array(100, 4, 200, 1, 3, 2)) == 4)
  }
}
