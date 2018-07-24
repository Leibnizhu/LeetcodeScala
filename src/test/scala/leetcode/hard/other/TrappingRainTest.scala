package leetcode.hard.other 

import org.scalatest.FunSuite

class TrappingRainTest extends FunSuite {
  test("sample1"){
    assert(TrappingRain.trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)) == 6)
  }
}