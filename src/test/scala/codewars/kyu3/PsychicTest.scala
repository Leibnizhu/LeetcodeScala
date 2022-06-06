package codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PsychicTest extends AnyFlatSpec with Matchers {
  /**
    * JDK9 以上版本执行需要增加VM参数
    * --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED
    */
  "The Psychic" should "guess correctly" in {
    Psychic.guess() shouldBe java.lang.Math.random()
  }
}