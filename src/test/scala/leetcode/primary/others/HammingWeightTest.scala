package leetcode.primary.others

import org.scalatest.funsuite.AnyFunSuite

class HammingWeightTest extends AnyFunSuite{
    test("11"){
      val ham = new HammingWeight()
      assert(ham.hammingWeight(11) == 3)
    }

  test("128"){
    val ham = new HammingWeight()
    assert(ham.hammingWeight(128) == 1)
  }

  test("0xFFFFFFFF"){
    val ham = new HammingWeight()
    assert(ham.hammingWeight(0x0FFFFFFFF) == 32)
  }
}
