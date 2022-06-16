package codewars.kyu3

import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import java.math.BigInteger
import java.math.BigInteger.ZERO
import java.math.BigInteger.valueOf

class FabergeEasterEggsCrushTestTest extends AnyFlatSpec with Matchers {
  it should "pass basic tests" in {
    FabergeEasterEggsCrushTestTest.test(1, 51, 51)
    FabergeEasterEggsCrushTestTest.test(2, 1, 1)
    FabergeEasterEggsCrushTestTest.test(4, 17, 3213)
    FabergeEasterEggsCrushTestTest.test(16, 19, 524096)
    FabergeEasterEggsCrushTestTest.test(23, 19, 524287)
  }

  it should "pass advanced tests" in {
    FabergeEasterEggsCrushTestTest.test("13", "550", "60113767426276772744951355")
    FabergeEasterEggsCrushTestTest.test("271", "550", "1410385042520538326622498273346382708200418583791594039531058458108130216985983794998105636900856496701928202738750818606797013840207721579523618137220278767326000095")
    FabergeEasterEggsCrushTestTest.test("531", "550", "3685510180489786476798393145496356338786055879312930105836138965083617346086082863365358130056307390177215209990980317284932211552658342317904346433026688858140133147")
  }
}

object FabergeEasterEggsCrushTestTest {
  private def test(a: Int, b: Int, shouldBe: Int): Unit = {
    assertResult(valueOf(shouldBe)) {
      FabergeEasterEggsCrushTest.height(valueOf(a), valueOf(b))
    }
  }

  private def test(a: String, b: String, shouldBe: String): Unit = {
    assertResult(new BigInteger(shouldBe)) {
      FabergeEasterEggsCrushTest.height(new BigInteger(a), new BigInteger(b))
    }
  }
}