package codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite

class ValidBracesTest extends AnyFunSuite {
  test("Samples") {
    assert(ValidBraces.validBraces("()"))
    assert(!ValidBraces.validBraces("[(])"))
    assert(ValidBraces.validBraces("(){}[]"))
    assert(ValidBraces.validBraces("([{}])"))
    assert(!ValidBraces.validBraces("(}"))
    assert(!ValidBraces.validBraces("[(])"))
    assert(!ValidBraces.validBraces("[({})](]"))
  }

  test("Samples2") {
    assert(!ValidBraces.validBraces("()(}{][)"))
    assert(!ValidBraces.validBraces("(((()"))
    assert(!ValidBraces.validBraces("(())({}}{()][][)"))
  }
}