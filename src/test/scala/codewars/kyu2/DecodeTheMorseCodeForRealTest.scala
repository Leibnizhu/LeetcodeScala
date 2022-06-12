package codewars.kyu2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite

class DecodeTheMorseCodeForRealTest extends AnyFlatSpec {

  import DecodeTheMorseCodeForReal._

  "The example from the description" should "return \"HEY JUDE\"" in {
    val result = decodeMorse(decodeBitsAdvanced("0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000"))
    println(result)
//FIXME    assertResult("HEY JUDE")(result)
  }
}