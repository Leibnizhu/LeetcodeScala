package leetcode.primary.design

import org.scalatest.FunSuite

class ShuffleArrayTest extends FunSuite {
  test("1,2,3 shuffle"){
    val arr = Array(1,2,3)
    val shuffle = new ShuffleArray(arr)
    for(i <- arr.indices)
      println(shuffle.shuffle().toList)
  }

  test("1,2,3 reset"){
    val arr = Array(1,2,3)
    val shuffle = new ShuffleArray(arr)
    for(i <- arr.indices)
      shuffle.shuffle()
    val reset = shuffle.reset()
    assert(reset sameElements arr)
  }

  test("1,2,3,4,5,6,7,8,9,0 shuffle"){
    val arr = Array(1,2,3,4,5,6,7,8,9,0)
    val shuffle = new ShuffleArray(arr)
    for(i <- arr.indices)
      println(shuffle.shuffle().toList)
  }
}
