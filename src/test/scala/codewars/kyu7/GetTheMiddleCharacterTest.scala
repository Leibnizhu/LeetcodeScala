package codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GetTheMiddleCharacterTest extends AnyFlatSpec with Matchers {

  val tests = List(
    ("test",    "es"),
    ("testing", "t"),
    ("middle",  "dd"),
    ("A",       "A"),
    ("of",      "of")
  )

  tests.foreach {
    case (input, expected) =>
      s"middle($input)" should s"return $expected" in {
        GetTheMiddleCharacter.middle(input) should be (expected)
      }
  }
}