package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MatrixDeterminantTest extends AnyFlatSpec with Matchers {

  val tests = List(
    (Array(Array(1)), 1, Some("Determinant of a 1 x 1 matrix yields the value of the one element.")),
    (Array(Array(1, 3), Array(2, 5)), -1, Some("Should return 1 * 5 - 3 * 2, i.e., -1.")),
    (Array(Array(2, 5, 3), Array(1, -2, -1), Array(1, 3, 4)), -20, None)
  )

  tests.foreach {
    case (matrix, expected, message) =>
      val matrixStr = s"Array(${matrix.map(r => s"Array(${r.mkString(", ")})").mkString(", ")})"
      s"determinant($matrixStr)" should s"return $expected" in {
        message match {
          case Some(error) => withClue(message) {
            MatrixDeterminant.determinant(matrix) should be(expected)
          }
          case None => MatrixDeterminant.determinant(matrix) should be(expected)
        }
      }
  }
}