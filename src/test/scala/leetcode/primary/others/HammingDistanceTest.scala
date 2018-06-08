package leetcode.primary.others

import org.scalatest.FunSuite

class HammingDistanceTest extends FunSuite{
  test("1,4"){
    assert(HammingDistance.hammingDistance(1,4) == 2)
  }

  test("0x7FFFFFFF,0"){
    assert(HammingDistance.hammingDistance(0x7FFFFFFF,0) == 31)
  }
}
