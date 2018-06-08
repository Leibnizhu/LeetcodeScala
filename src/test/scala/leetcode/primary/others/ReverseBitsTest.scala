package leetcode.primary.others

import org.scalatest.FunSuite

class ReverseBitsTest extends FunSuite{
  test("43261596"){
    val reverse = new ReverseBits()
    assert(reverse.reverseBits(43261596) == 964176192)
  }

  test("0xFFFFFFFF"){
    val reverse = new ReverseBits()
    assert(reverse.reverseBits(0xFFFFFFFF) == 0xFFFFFFFF)
  }

  test("0xAAAAAAAA"){
    val reverse = new ReverseBits()
    assert(reverse.reverseBits(0xAAAAAAAA) == 0x55555555)
  }
}
