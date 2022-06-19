package codewars.kyu1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.math.BigInteger

class FabergeEasterEggsCrushTestLinearTest extends AnyFlatSpec with Matchers {

  it should "work for some basic tests" in {
    FabergeEasterEggsCrushTestLinear.height(BigInt(1), BigInt(51)) should be(BigInt(51))
    FabergeEasterEggsCrushTestLinear.height(BigInt(2), BigInt(1)) should be(BigInt(1))
    FabergeEasterEggsCrushTestLinear.height(BigInt(4), BigInt(17)) should be(BigInt(3213))
    FabergeEasterEggsCrushTestLinear.height(BigInt(16), BigInt(19)) should be(BigInt(524096))
    FabergeEasterEggsCrushTestLinear.height(BigInt(23), BigInt(19)) should be(BigInt(524287))
  }

  it should "work for some advanced tests" in {
    FabergeEasterEggsCrushTestLinear.height(BigInt(13), BigInt(550)) should be(BigInt(621773656))
    FabergeEasterEggsCrushTestLinear.height(BigInt(531), BigInt(550)) should be(BigInt(424414512))
  }

  it should "work for some serious tests :)" in {
    FabergeEasterEggsCrushTestLinear.height(BigInt(10).pow(4), BigInt(10).pow(5)) should be(BigInt(132362171))
    FabergeEasterEggsCrushTestLinear.height(BigInt(8) * (BigInt(10).pow(4)), BigInt(10).pow(5)) should be(BigInt(805097588))
    FabergeEasterEggsCrushTestLinear.height(BigInt(3000), BigInt(2).pow(200)) should be(BigInt(141903106))
    FabergeEasterEggsCrushTestLinear.height(BigInt(8) * (BigInt(10).pow(4)), BigInt(4) * (BigInt(10).pow(4))) should be(BigInt(616494770))
    FabergeEasterEggsCrushTestLinear.height(BigInt(4) * (BigInt(10).pow(4)), BigInt(8) * (BigInt(10).pow(4))) should be(BigInt(303227698))
  }


  it should "work for some basic tests for Java" in {
    assertResult(BigInteger.ZERO)(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.ZERO, BigInteger.valueOf(14)))
    assertResult(BigInteger.ZERO)(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(2), BigInteger.ZERO))
    assertResult(BigInteger.valueOf(105))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(2), BigInteger.valueOf(14)))
    assertResult(BigInteger.valueOf(137979))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(7), BigInteger.valueOf(20)))
  }

  it should "work for some advanced tests for Java" in {
    assertResult(BigInteger.valueOf(621773656))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(13), BigInteger.valueOf(550)))
    assertResult(BigInteger.valueOf(424414512))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(531), BigInteger.valueOf(550)))
  }

  it should "work for some serious tests  for Java" in {
    import java.math.BigInteger
    assertResult(BigInteger.valueOf(132362171))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(10000), BigInteger.valueOf(100000)))
    assertResult(BigInteger.valueOf(805097588))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(80000), BigInteger.valueOf(100000)))
    assertResult(BigInteger.valueOf(141903106))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(3000), BigInteger.valueOf(2).pow(200)))
    assertResult(BigInteger.valueOf(616494770))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(80000), BigInteger.valueOf(40000)))
    assertResult(BigInteger.valueOf(303227698))(FabergeEasterEggsCrushTestLinearJava.height(BigInteger.valueOf(40000), BigInteger.valueOf(80000)))
  }
}
