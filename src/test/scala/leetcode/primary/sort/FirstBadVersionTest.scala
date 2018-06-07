package leetcode.primary.sort

import org.scalatest.FunSuite

class FirstBadVersionTest extends FunSuite {
  test("total 5, first bad in 4") {
    val version = new FirstBadVersion(4)
    assert(version.firstBadVersion(5) == 4)
  }

  test("total 5, first bad in 0") {
    val version = new FirstBadVersion(0)
    assert(version.firstBadVersion(5) == 0)
  }

  test("total 5, first bad in 1") {
    val version = new FirstBadVersion(1)
    assert(version.firstBadVersion(5) == 1)
  }

  test("total max, first bad in 1") {
    val version = new FirstBadVersion(1)
    assert(version.firstBadVersion(Int.MaxValue) == 1)
  }
}
