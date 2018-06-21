package leetcode.medium.sortsearch

import leetcode.medium.math.HappyNumber
import org.scalatest.FunSuite

class HappyNumberTest extends FunSuite{
  /**
    * 1 pow 2 + 9 pow 2 = 82
    * 8 pow 2 + 2 pow 2 = 68
    * 6 pow 2 + 8 pow 2 = 100
    * 1 pow 2 + 0 pow 2 + 0 pow 2 = 1
    */
  test("19"){
    assert(HappyNumber.isHappy(19))
  }

  test("1"){
    assert(HappyNumber.isHappy(1))
  }

  test("2"){
    assert(!HappyNumber.isHappy(2))
  }
}
