package codewars.kyu5

import codewars.kyu5.SimpleAssemblerInterpreter.interpret
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SimpleAssemblerInterpreterTest extends AnyFlatSpec with Matchers {
  "interpret(List(\"mov a 5\",\"inc a\",\"dec a\",\"dec a\",\"jnz a -1\",\"inc a\"))" should "return Map(\"a\"->1)" in {
    interpret(List("mov a 5","inc a","dec a","dec a","jnz a -1","inc a")) should be (Map("a"->1))
  }

  "interpret(List(\"mov a -10\",\"mov b a\",\"inc a\",\"dec b\",\"jnz a -2\"))" should "return Map(\"a\"->0,\"b\"->-20)" in {
    interpret(List("mov a -10","mov b a","inc a","dec b","jnz a -2")) should be (Map("a"->0,"b"->(-20)))
  }
}
