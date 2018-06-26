package leetcode.hard.arraystring

import org.scalatest.FunSuite

class MaxAreaTest extends FunSuite{
  test("1,2"){
    assert(MaxArea.maxArea(Array(1,2)) == 1)
  }

  test("1,2,3,4,5,6,7,8"){
    assert(MaxArea.maxArea(Array(1,2,3,4,5,6,7,8)) == 16)
  }

  test("1,2,3,4,5,4,3,2,1"){
    assert(MaxArea.maxArea(Array(1,2,3,4,5,4,3,2,1)) == 12)
  }

  test("1,2,4,3,3,4,2,1"){
    assert(MaxArea.maxArea(Array(1,2,4,3,3,4,2,1)) == 12)
  }
}
