package codewars.kyu6

import codewars.kyu6.DecodeTheMorseCode.decode
import org.scalatest.flatspec.AnyFlatSpec

class DecodeTheMorseCodeTest extends AnyFlatSpec {
  "the example from the description" should "return \"HEY JUDE\"" in {
    assertResult("HEY JUDE")(decode(".... . -.--   .--- ..- -.. ."))
  }

  "decode( . )" should "return E" in {
    assertResult("E")(decode(" . "))
  }

  "decode(   .   . )" should "return E E" in {
    assertResult("E E")(decode(" .   . "))
  }

  "decode(      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-     )" should "return SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG." in {
    assertResult("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.")(decode("      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-     "))
  }
}