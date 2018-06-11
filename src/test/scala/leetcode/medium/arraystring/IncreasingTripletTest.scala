package leetcode.medium.arraystring

import org.scalatest.FunSuite

class IncreasingTripletTest extends FunSuite {
  test("1, 2, 3, 4, 5") {
    assert(IncreasingTriplet.increasingTriplet(Array(1, 2, 3, 4, 5)))
  }

  test("5, 4, 3, 2, 1") {
    assert(!IncreasingTriplet.increasingTriplet(Array(5, 4, 3, 2, 1)))
  }

  test("1, 8, 3, 7, 5") {
    assert(IncreasingTriplet.increasingTriplet(Array(1, 8, 3, 7, 5)))
  }

  test("3, 8, 1, -2, -1, 2") {
    assert(IncreasingTriplet.increasingTriplet(Array(3, 8, 1, -2, -1, 2)))
  }

  test("2,1,5,0,3") {
    assert(!IncreasingTriplet.increasingTriplet(Array(2, 1, 5, 0, 3)))
  }

  test("1,2,3") {
    assert(IncreasingTriplet.increasingTriplet(Array(1, 2, 3)))
  }

  test("1,2") {
    assert(!IncreasingTriplet.increasingTriplet(Array(1, 2)))
  }

  test("1") {
    assert(!IncreasingTriplet.increasingTriplet(Array(1)))
  }

  test("empty") {
    assert(!IncreasingTriplet.increasingTriplet(Array()))
  }
}