package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HumanReadableDurationFormatTest extends AnyFlatSpec with Matchers {

  val tests = List(
    (0, "now"),
    (1, "1 second"),
    (62, "1 minute and 2 seconds"),
    (120, "2 minutes"),
    (3600, "1 hour"),
    (3662, "1 hour, 1 minute and 2 seconds"),
    (15731080, "182 days, 1 hour, 44 minutes and 40 seconds"),
    (132030240, "4 years, 68 days, 3 hours and 4 minutes"),
    (205851834, "6 years, 192 days, 13 hours, 3 minutes and 54 seconds"),
  )

  tests.foreach {
    case (input, expected) =>
      s"format($input)" should s"return $expected" in {
        HumanReadableDurationFormat.formatDuration(input) should be(expected)
      }
  }
}
