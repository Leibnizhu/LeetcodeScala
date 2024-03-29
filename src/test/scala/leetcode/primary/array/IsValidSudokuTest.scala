package leetcode.primary.array

import org.scalatest.funsuite.AnyFunSuite

class IsValidSudokuTest extends AnyFunSuite {
  /**
    * 输入:
    * [
    * ['5','3','.','.','7','.','.','.','.'],
    * * ['6','.','.','1','9','5','.','.','.'],
    * * ['.','9','8','.','.','.','.','6','.'],
    * * ['8','.','.','.','6','.','.','.','3'],
    * * ['4','.','.','8','.','3','.','.','1'],
    * * ['7','.','.','.','2','.','.','.','6'],
    * * ['.','6','.','.','.','.','2','8','.'],
    * * ['.','.','.','4','1','9','.','.','5'],
    * * ['.','.','.','.','8','.','.','7','9']
    * ]
    * 输出: true
    */
  test("case1 ,true") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    val result = IsValidSudoku.isValidSudoku(board)
    assert(result)
  }

  /**
    * 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 case1 相同。
    * 但由于位于最左列有两个 8 存在, 因此这个数独是无效的。
    */
  test("case2 ,false") {
    val board = Array(
      Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    val result = IsValidSudoku.isValidSudoku(board)
    assert(!result)
  }

  /**
    * 除了第2行的第2个数字从 . 改为 8 以外，空格内其他数字均与 case1 相同。
    * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
    */
  test("case3 ,false") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '8', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    val result = IsValidSudoku.isValidSudoku(board)
    assert(!result)
  }
}
