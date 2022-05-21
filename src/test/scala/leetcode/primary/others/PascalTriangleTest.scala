package leetcode.primary.others

import org.scalatest.funsuite.AnyFunSuite

class PascalTriangleTest extends AnyFunSuite{
  test("1"){
    val result = PascalTriangle.generate(1)
    result.foreach(println(_))
    assert(result.length == 1)
    assert(result.head == List(1))
  }

  test("2"){
    val result = PascalTriangle.generate(2)
    result.foreach(println(_))
    assert(result.length == 2)
    assert(result.head == List(1))
    assert(result(1) == List(1,1))
  }

  test("3"){
    val result = PascalTriangle.generate(3)
    result.foreach(println(_))
    assert(result.length == 3)
    assert(result.head == List(1))
    assert(result(1) == List(1,1))
    assert(result(2) == List(1,2,1))
  }

  test("4"){
    val result = PascalTriangle.generate(4)
    result.foreach(println(_))
    assert(result.length == 4)
    assert(result.head == List(1))
    assert(result(1) == List(1,1))
    assert(result(2) == List(1,2,1))
    assert(result(3) == List(1,3,3,1))
  }

  test("5"){
    val result = PascalTriangle.generate(5)
    result.foreach(println(_))
    assert(result.length == 5)
    assert(result.head == List(1))
    assert(result(1) == List(1,1))
    assert(result(2) == List(1,2,1))
    assert(result(3) == List(1,3,3,1))
    assert(result(4) == List(1,4,6,4,1))
  }
}
