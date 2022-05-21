package leetcode.hard.treegraph

import org.scalatest.funsuite.AnyFunSuite

class SurroundedRegionsTest extends AnyFunSuite {
  test("empty") {
    val board = Array[Array[Char]]()
    SurroundedRegions.solve(board)
    assert(board.isEmpty)
  }

  test("sample1") {
    val board = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'X', 'O', 'X'),
      Array('X', 'O', 'X', 'X')
    )
    SurroundedRegions.solve(board)
    assert(board(0) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(1) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(2) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(3) sameElements Array('X', 'O', 'X', 'X'))
  }

  test("sample2") {
    val board = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'X', 'O', 'X'),
      Array('X', 'O', 'X', 'X'),
      Array('X', 'O', 'X', 'X')
    )
    SurroundedRegions.solve(board)
    assert(board(0) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(1) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(2) sameElements Array('X', 'O', 'X', 'X'))
    assert(board(3) sameElements Array('X', 'O', 'X', 'X'))
  }

  test("sample3") {
    val board = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'X', 'X', 'X')
    )
    SurroundedRegions.solve(board)
    assert(board(0) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(1) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(2) sameElements Array('X', 'X', 'X', 'X'))
    assert(board(3) sameElements Array('X', 'X', 'X', 'X'))
  }
}
