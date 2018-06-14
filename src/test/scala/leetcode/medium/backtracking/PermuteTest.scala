package leetcode.medium.backtracking

import org.scalatest.FunSuite

class PermuteTest extends FunSuite{
  test("1,2,3"){
    val result = Permute.permute(Array(1,2,3))
    println(result)
    assert(result.length == 6)
    assert(result(0) == List(1,2,3))
    assert(result(1) == List(1,3,2))
    assert(result(2) == List(2,1,3))
    assert(result(3) == List(2,3,1))
    assert(result(4) == List(3,1,2))
    assert(result(5) == List(3,2,1))
  }

  test("1,2"){
    val result = Permute.permute(Array(1,2))
    println(result)
    assert(result.length == 2)
    assert(result(0) == List(1,2))
    assert(result(1) == List(2,1))
  }

  test("5"){
    val result = Permute.permute(Array(5))
    println(result)
    assert(result.length == 1)
    assert(result(0) == List(5))
  }
}
