package leetcode.hard.math

import org.scalatest.FunSuite

class LargestNumberTest extends FunSuite {
  test("10,2") {
    assert(LargestNumber.largestNumber(Array(10, 2)) == "210")
    assert(LargestNumber.largestNumber(Array(2, 10)) == "210")
  }

  test("3,30,34,5,9") {
    assert(LargestNumber.largestNumber(Array(3, 30, 34, 5, 9)) == "9534330")
    assert(LargestNumber.largestNumber(Array(3, 30, 34, 5, 9).sorted) == "9534330")
  }

  test("0,0") {
    assert(LargestNumber.largestNumber(Array(0, 0)) == "0")
  }
}
