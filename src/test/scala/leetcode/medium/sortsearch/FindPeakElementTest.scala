package leetcode.medium.sortsearch

import org.scalatest.funsuite.AnyFunSuite

class FindPeakElementTest extends AnyFunSuite{
  test("1,2,3,1"){
    val res = FindPeakElement.findPeakElement(Array(1,2,3,1))
    assert(res == 2)
  }

  test("1,2,1,3,5,6,4"){
    val res = FindPeakElement.findPeakElement(Array(1,2,1,3,5,6,4))
    assert(res == 1 || res == 5)
  }
}
