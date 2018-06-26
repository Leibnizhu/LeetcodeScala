package leetcode.hard.arraystring

import org.scalatest.FunSuite

class SpiralMatrixTest extends FunSuite {
  test("empty") {
    assert(SpiralMatrix.spiralOrder(Array()) == List())
  }

  test("1") {
    assert(SpiralMatrix.spiralOrder(Array(
      Array(1)
    )) == List(1))
  }

  test("1,2,3,4,5") {
    assert(SpiralMatrix.spiralOrder(Array(
      Array(1, 2, 3, 4, 5)
    )) == List(1, 2, 3, 4, 5))
  }

  test("1,2,4,3") {
    assert(SpiralMatrix.spiralOrder(Array(
      Array(1, 2),
      Array(3, 4)
    )) == List(1, 2, 4, 3))
  }

  test("1,2,3,6,9,8,7,4,5") {
    assert(SpiralMatrix.spiralOrder(Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )) == List(1, 2, 3, 6, 9, 8, 7, 4, 5))
  }

  test("1,2,3,4,8,12,11,10,9,5,6,7") {
    assert(SpiralMatrix.spiralOrder(Array(
      Array(1, 2, 3, 4),
      Array(5, 6, 7, 8),
      Array(9, 10, 11, 12)
    )) == List(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
  }
}
