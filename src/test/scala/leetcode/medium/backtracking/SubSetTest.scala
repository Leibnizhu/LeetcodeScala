package leetcode.medium.backtracking

import org.scalatest.FunSuite

class SubSetTest extends FunSuite{
  test("1,2,3"){
    val result = SubSet.subsets(Array(1,2,3))
    result.foreach(println(_))
    assert(result.length == 8)
    assert(result.head == List(1,2,3))
    assert(result(1) == List(1,2))
    assert(result(2) == List(1,3))
    assert(result(3) == List(1))
    assert(result(4) == List(2,3))
    assert(result(5) == List(2))
    assert(result(6) == List(3))
    assert(result(7) == List())
  }

  test("1,2"){
    val result = SubSet.subsets(Array(1,2))
    result.foreach(println(_))
    assert(result.length == 4)
    assert(result.head == List(1,2))
    assert(result(1) == List(1))
    assert(result(2) == List(2))
    assert(result(3) == List())
  }

  test("5"){
    val result = SubSet.subsets(Array(5))
    result.foreach(println(_))
    assert(result.length == 2)
    assert(result.head == List(5))
    assert(result(1) == List())
  }

  test("empty"){
    val result = SubSet.subsets(Array())
    result.foreach(println(_))
    assert(result.isEmpty)
  }
}
