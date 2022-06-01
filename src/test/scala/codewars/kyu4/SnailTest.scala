package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec

class SnailTest extends AnyFlatSpec {

  import Snail.snail

  "My example" should "work" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    assert(snail(input, 1) == List(5))
    assert(snail(input, 2) == List(1, 2, 3, 6, 9, 8, 7, 4))
  }

  "0x0" should "work" in {
    assert(snail(List(List())) == List())
    assert(snail(List()) == List())
  }

  "1x1" should "work" in {
    val input = List(List(5))
    assert(snail(input) == List(5))
  }

  "2x2" should "work" in {
    val input = List(
      List(1, 2),
      List(3, 4))
    assert(snail(input) == List(1, 2, 4, 3))
  }

  "First example" should "work" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(1, 2, 3, 6, 9, 8, 7, 4, 5)
    assert(snail(input) == res)
  }

  "Second example" should "work" in {
    val input = List(
      List(1, 2, 3),
      List(8, 9, 4),
      List(7, 6, 5))
    val res = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(snail(input) == res)
  }
}