package leetcode.hard.sortsearch

import org.scalatest.funsuite.AnyFunSuite

import scala.language.implicitConversions
import leetcode.hard.sortsearch.WiggleSort.base

class WiggleSortTest extends AnyFunSuite {
  test("1, 5, 1, 1, 6, 4") {
    val arr = Array(1, 5, 1, 1, 6, 4)
    WiggleSort.wiggleSort(arr)
    println(arr.toList)
    assert(check(arr))
  }

  test("1, 3, 2, 2, 3, 1") {
    val arr = Array(1, 3, 2, 2, 3, 1)
    WiggleSort.wiggleSort(arr)
    println(arr.toList)
    assert(check(arr))
  }

  test("1") {
    val arr = Array(1)
    WiggleSort.wiggleSort(arr)
    println(arr.toList)
    assert(check(arr))
  }

  test("1,3,2,2,2,1,1,3,1,1,2") {
    val arr = Array(1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2)
    WiggleSort.wiggleSort(arr)
    println(arr.toList)
    assert(check(arr))
  }

  def check(arr: Array[Int]): Boolean = (1 until arr.length) forall {
    case i if i % 2 == 1 => arr(i - 1) < arr(i)
    case i => arr(i - 1) > arr(i)
  }

  test("middle") {
    assert(WiggleSort.findKth(Array(1, 5, 1, 1, 6, 4), 3) == 1)
    assert(WiggleSort.findKth(Array(1, 3, 2, 2, 3, 1), 7/2) == 2)
    assert(WiggleSort.findKth(Array(1, 4, 5, 2, 3, 7, 6), 4) == 4)
    assert(WiggleSort.findKth(Array(1), 1) == 1)
    assert(WiggleSort.findKth(Array(1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2), 6) == 2)
  }
}
