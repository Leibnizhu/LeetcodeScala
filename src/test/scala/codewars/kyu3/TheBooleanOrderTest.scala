package codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TheBooleanOrderTest extends AnyFlatSpec with Matchers {
  "Scala solution" should "pass tests" in {
    TheBooleanOrder.solve("tft", "^&") should be (2L)
    TheBooleanOrder.solve("ttftff", "|&^&&") should be (16L)
    TheBooleanOrder.solve("ttftfftf", "|&^&&||") should be (339L)
    TheBooleanOrder.solve("ttftfftft", "|&^&&||^") should be (851L)
    TheBooleanOrder.solve("ttftfftftf", "|&^&&||^&") should be (2434L)
    TheBooleanOrder.solve("ttftfftftffttfftftftfftft", "|&^&&||^&&^^|&&||^&&||&^") should be (945766470799L)
  }
}
