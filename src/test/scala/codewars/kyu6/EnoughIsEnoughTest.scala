package codewars.kyu6

import codewars.kyu6.EnoughIsEnough.deleteNth
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop._

class EnoughIsEnoughTest extends AnyFunSuite with TableDrivenPropertyChecks with Matchers {
  test("fixed tests") {
    val fixedTests = Table[List[Int], Int, List[Int]](
      ("elements", "n", "expected"),
      (List(20, 37, 20, 21), 1, List(20, 37, 21)),
      (List(1, 1, 3, 3, 7, 2, 2, 2, 2), 3, List(1, 1, 3, 3, 7, 2, 2, 2)),
      (List(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3, List(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5)),
      (List(1, 1, 1, 1, 1), 5, List(1, 1, 1, 1, 1)),
      (List(), 5, List())
    )
    forAll(fixedTests) {
      deleteNth(_, _) shouldBe _
    }
  }
}
