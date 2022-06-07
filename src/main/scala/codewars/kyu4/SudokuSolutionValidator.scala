package codewars.kyu4

/**
  * 2022-06-08
  * {@see <a href='https://www.codewars.com/kata/529bf0e9bdf7657179000008/train/scala'/> }
  */
object SudokuSolutionValidator {
  def isValid(board: Array[Array[Int]]): Boolean = {
    val fullSet = (1 to 9).toSet
    board.forall(_.toSet == fullSet) &&
      board.transpose.forall(_.toSet == fullSet) &&
      (for {
        row <- 0 to 2
        column <- 0 to 2
        i <- row * 3 to row * 3 + 2
        j <- column * 3 to column * 3 + 2
      } yield board(i)(j)).grouped(9).forall(_.toSet == fullSet)
  }
}
