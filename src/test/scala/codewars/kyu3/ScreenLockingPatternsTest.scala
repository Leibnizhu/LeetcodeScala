package codewars.kyu3

import org.scalatest.funsuite.AnyFunSuite

class ScreenLockingPatternsTest extends AnyFunSuite {
  test("Basic tests") {
    assert(ScreenLockingPatterns.countPatternsFrom('A', 0) === 0)
    assert(ScreenLockingPatterns.countPatternsFrom('A', 10) === 0)
    assert(ScreenLockingPatterns.countPatternsFrom('B', 1) === 1)
    assert(ScreenLockingPatterns.countPatternsFrom('C', 2) === 5)
    assert(ScreenLockingPatterns.countPatternsFrom('D', 3) === 37)
    assert(ScreenLockingPatterns.countPatternsFrom('E', 4) === 256)
    assert(ScreenLockingPatterns.countPatternsFrom('E', 8) === 23280)
  }
}
