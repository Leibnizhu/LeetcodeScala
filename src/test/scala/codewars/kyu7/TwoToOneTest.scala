package codewars.kyu7

import codewars.kyu7.TwoToOne.longest
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop._

class EnoughIsEnoughTest extends AnyFunSuite with TableDrivenPropertyChecks with Matchers {
  test("fixed tests") {
    val fixedTests = Table[String, String, String](
      ("elements", "n", "expected"),
      ("aretheyhere", "yestheyarehere", "aehrsty"),
      ("loopingisfunbutdangerous", "lessdangerousthancoding", "abcdefghilnoprstu"),
      ("inmanylanguages", "theresapairoffunctions", "acefghilmnoprstuy")
    )
    forAll(fixedTests) {
      longest(_, _) shouldBe _
    }
  }
}
