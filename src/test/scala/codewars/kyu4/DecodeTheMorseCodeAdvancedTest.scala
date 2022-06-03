package codewars.kyu4

import codewars.kyu4.DecodeTheMorseCodeAdvanced.{decodeBits, decodeMorse}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite

class DecodeTheMorseCodeAdvancedTest extends AnyFlatSpec {
  "The example from the description" should "return \"HEY JUDE\"" in {
    assertResult("HEY JUDE")(decodeMorse(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")))
  }
}