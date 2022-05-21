package leetcode.medium.dynamic

import org.scalatest.funsuite.AnyFunSuite

class JumpGameTest extends AnyFunSuite {
  test("2,3,1,1,4") {
    assert(JumpGame.canJump(Array(2, 3, 1, 1, 4)))
  }

  test("2,3,0,0,4") {
    assert(JumpGame.canJump(Array(2, 3, 0, 0, 4)))
  }

  test("3,2,1,0,4") {
    assert(!JumpGame.canJump(Array(3, 2, 1, 0, 4)))
  }

  test("2") {
    assert(JumpGame.canJump(Array(2)))
  }

  test("null") {
    assert(!JumpGame.canJump(null))
  }

  test("empty") {
    assert(!JumpGame.canJump(Array()))
  }

  test("0,2,3") {
    assert(!JumpGame.canJump(Array(0, 2, 3)))
  }

  test("2,0,0") {
    assert(JumpGame.canJump(Array(2, 0, 0)))
  }
}
