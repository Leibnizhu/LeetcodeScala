package leetcode.primary.math

import org.scalatest.FunSuite

class FizzBuzzTest extends FunSuite {
  test("15") {
    assert(FizzBuzz.fizzBuzz(15) == List("1", "2", "Fizz", "4", "Buzz", "Fizz", "7",
      "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
  }

  test("1") {
    assert(FizzBuzz.fizzBuzz(1) == List("1"))
  }
}
