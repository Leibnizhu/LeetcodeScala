package leetcode.hard.sortsearch

import org.scalatest.FunSuite

class WiggleSortTest extends FunSuite {
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

  def check(arr: Array[Int]): Boolean = (1 until arr.length) forall {
    case i if i % 2 == 1 => arr(i - 1) < arr(i)
    case i => arr(i - 1) > arr(i)
  }
}
