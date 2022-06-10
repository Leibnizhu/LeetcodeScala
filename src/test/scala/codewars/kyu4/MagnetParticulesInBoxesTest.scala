package codewars.kyu4

import codewars.kyu4.MagnetParticulesInBoxesTest.assertFuzzyEquals
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite

class MagnetParticulesInBoxesTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assertFuzzyEquals(MagnetParticulesInBoxes.doubles(10, 1000), 0.6921486500921933)
    assertFuzzyEquals(MagnetParticulesInBoxes.doubles(10, 10000), 0.6930471674194457)

  }
}

object MagnetParticulesInBoxesTest {
  private def assertFuzzyEquals(act: Double, expect: Double): Unit = {
    val merr: Double = 1e-6
    println("Actual: " + act)
    println("Expect: " + expect)
    val inrange: Boolean = Math.abs(act - expect) <= merr
    if (inrange == false) {
      println("Expected must be near " + expect + ", got " + act)
    }
    assertResult(true) {
      inrange
    }
  }
}

