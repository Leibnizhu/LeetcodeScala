package leetcode.primary.array

import org.scalatest.FunSuite

class RotateMatrixTest extends FunSuite {
  /**
    * 给定 matrix =
    * [
    * [1,2,3],
    * [4,5,6],
    * [7,8,9]
    * ],
    *
    * 原地旋转输入矩阵，使其变为:
    * [
    * [7,4,1],
    * [8,5,2],
    * [9,6,3]
    * ]
    */
  test("3x3 Matrix") {
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    RotateMatrix.rotate(matrix)
    assert(matrix(0) sameElements Array(7, 4, 1))
    assert(matrix(1) sameElements Array(8, 5, 2))
    assert(matrix(2) sameElements Array(9, 6, 3))
  }

  /**
    * 给定 matrix =
    * [
    * [ 5, 1, 9,11],
    * [ 2, 4, 8,10],
    * [13, 3, 6, 7],
    * [15,14,12,16]
    * ],
    *
    * 原地旋转输入矩阵，使其变为:
    * [
    * [15,13, 2, 5],
    * [14, 3, 4, 1],
    * [12, 6, 8, 9],
    * [16, 7,10,11]
    * ]
    */
  test("4x4 Matrix") {
    val matrix = Array(
      Array(5, 1, 9, 11),
      Array(2, 4, 8, 10),
      Array(13, 3, 6, 7),
      Array(15, 14, 12, 16)
    )
    RotateMatrix.rotate(matrix)
    assert(matrix(0) sameElements Array(15, 13, 2, 5))
    assert(matrix(1) sameElements Array(14, 3, 4, 1))
    assert(matrix(2) sameElements Array(12, 6, 8, 9))
    assert(matrix(3) sameElements Array(16, 7, 10, 11))
  }
}
