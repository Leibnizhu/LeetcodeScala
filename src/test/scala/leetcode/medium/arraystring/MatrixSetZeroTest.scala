package leetcode.medium.arraystring

import org.scalatest.funsuite.AnyFunSuite

class MatrixSetZeroTest extends AnyFunSuite {
  test("[1,1,1], [1,0,1], [1,1,1]") {
    val matrix = Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1))
    MatrixSetZero.setZeroes(matrix)
    matrix.foreach(row => println(row.toList))
    assert(matrix.head sameElements Array(1, 0, 1))
    assert(matrix(1) sameElements Array(0, 0, 0))
    assert(matrix(2) sameElements Array(1, 0, 1))
  }

  test("[0,1,2,0], [3,4,5,2], [1,3,1,5]") {
    val matrix = Array(
      Array(0, 1, 2, 0),
      Array(3, 4, 5, 2),
      Array(1, 3, 1, 5))
    MatrixSetZero.setZeroes(matrix)
    matrix.foreach(row => println(row.toList))
    assert(matrix.head sameElements Array(0, 0, 0, 0))
    assert(matrix(1) sameElements Array(0, 4, 5, 0))
    assert(matrix(2) sameElements Array(0, 3, 1, 0))
  }
}
