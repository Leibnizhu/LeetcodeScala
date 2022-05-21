package leetcode.hard.arraystring

import org.scalatest.funsuite.AnyFunSuite

class FirstMissingPositiveTest extends AnyFunSuite {
  test("1,2,0") {
    assert(FirstMissingPositive.firstMissingPositive(Array(1, 2, 0)) == 3)
  }

  test("3,4,-1,1") {
    assert(FirstMissingPositive.firstMissingPositive(Array(3, 4, -1, 1)) == 2)
  }

  test("7,8,9,11,12") {
    assert(FirstMissingPositive.firstMissingPositive(Array(7, 8, 9, 11, 12)) == 1)
  }

  test("3,1,2") {
    assert(FirstMissingPositive.firstMissingPositive(Array(3, 1, 2)) == 4)
  }

  test("empty") {
    assert(FirstMissingPositive.firstMissingPositive(Array()) == 1)
  }

  test("1,1") {
    assert(FirstMissingPositive.firstMissingPositive(Array(1, 1)) == 2)
  }
}
