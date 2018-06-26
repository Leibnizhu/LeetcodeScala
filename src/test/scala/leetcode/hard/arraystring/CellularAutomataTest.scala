package leetcode.hard.arraystring

import org.scalatest.FunSuite

class CellularAutomataTest extends FunSuite {
  test("sample1") {
    val board = Array(
      Array(0, 1, 0),
      Array(0, 0, 1),
      Array(1, 1, 1),
      Array(0, 0, 0)
    )
    CellularAutomata.gameOfLife(board)
    board.foreach(row => {row.foreach(print);println("")})
    assert(board(0) sameElements Array(0, 0, 0))
    assert(board(1) sameElements Array(1, 0, 1))
    assert(board(2) sameElements Array(0, 1, 1))
    assert(board(3) sameElements Array(0, 1, 0))
  }
}
