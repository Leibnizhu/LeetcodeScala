package codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TheMillionthFibonacciKataTest extends AnyFlatSpec with Matchers {
  "fib(0)" should "return 0" in {
    TheMillionthFibonacciKata.fib(0) should be(0)
  }
  "fib(1)" should "return 1" in {
    TheMillionthFibonacciKata.fib(1) should be(1)
  }
  "fib(2)" should "return 1" in {
    TheMillionthFibonacciKata.fib(2) should be(1)
  }
  "fib(3)" should "return 2" in {
    TheMillionthFibonacciKata.fib(3) should be(2)
  }
  "fib(4)" should "return 3" in {
    TheMillionthFibonacciKata.fib(4) should be(3)
  }
  "fib(5)" should "return 5" in {
    TheMillionthFibonacciKata.fib(5) should be(5)
  }
  "fib(-6)" should "return -8" in {
    TheMillionthFibonacciKata.fib(-6) should be(-8)
  }
}