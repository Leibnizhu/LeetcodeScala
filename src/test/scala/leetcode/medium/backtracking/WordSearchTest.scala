package leetcode.medium.backtracking

import org.scalatest.funsuite.AnyFunSuite

class WordSearchTest extends AnyFunSuite {
  test("sample 1") {
    val board = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    assert(WordSearch.exist(board, "ABCCED"))
    assert(WordSearch.exist(board, "SEE"))
    assert(!WordSearch.exist(board, "ABCB"))
  }
}
