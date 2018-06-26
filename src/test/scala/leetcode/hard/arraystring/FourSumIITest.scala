package leetcode.hard.arraystring

import org.scalatest.FunSuite

class FourSumIITest extends FunSuite {
  /**
    * 两个元组如下:
    * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
    */
  test("sample") {
    assert(FourSumII.fourSumCount(Array(1, 2), Array(-2, -1), Array(-1, 2), Array(0, 2)) == 2)
  }
}
