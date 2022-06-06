package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberOfProperFractionsWithDenominatorDTest extends AnyFlatSpec with Matchers {
  "properFractions(1)" should "return 0" in {
    NumberOfProperFractionsWithDenominatorD.properFractions(1) should be(0)
  }
  "properFractions(2)" should "return 1" in {
    NumberOfProperFractionsWithDenominatorD.properFractions(2) should be(1)
  }
  "properFractions(5)" should "return 4" in {
    NumberOfProperFractionsWithDenominatorD.properFractions(5) should be(4)
  }
  "properFractions(15)" should "return 8" in {
    NumberOfProperFractionsWithDenominatorD.properFractions(15) should be(8)
  }
  "properFractions(25)" should "return 20" in {
    NumberOfProperFractionsWithDenominatorD.properFractions(25) should be(20)
  }
}  

