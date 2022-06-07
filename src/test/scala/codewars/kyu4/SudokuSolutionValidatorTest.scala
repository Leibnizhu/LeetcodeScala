package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SudokuSolutionValidatorTest extends AnyFlatSpec with Matchers {

  val validBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
  )
  s"${validBoard.map(_.mkString(" ")).mkString("\n")}" should s"be valid" in {
    SudokuSolutionValidator.isValid(validBoard) should be (true)
  }

  val invalidBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 0, 3, 4, 9),
    Array(1, 0, 0, 3, 4, 2, 5, 6, 0),
    Array(8, 5, 9, 7, 6, 1, 0, 2, 0),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 0, 1, 5, 3, 7, 2, 1, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 0, 0, 4, 8, 1, 1, 7, 9)
  )
  s"${invalidBoard.map(_.mkString(" ")).mkString("\n")}" should s"be invalid" in {
    SudokuSolutionValidator.isValid(invalidBoard) should be (false)
  }
}