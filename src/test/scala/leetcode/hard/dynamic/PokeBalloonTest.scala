package leetcode.hard.dynamic

import org.scalatest.funsuite.AnyFunSuite

class PokeBalloonTest extends AnyFunSuite {
  test("3") {
    assert(PokeBalloon.maxCoins(Array(3)) == 3)
  }

  test("3,1,5,8") {
    assert(PokeBalloon.maxCoins(Array(3, 1, 5, 8)) == 167)
  }
}
