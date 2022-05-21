package leetcode.hard.other

import org.scalatest.funsuite.AnyFunSuite

class SkyLineTest extends AnyFunSuite {
  test("sample1") {
    check(Array(Array(2, 9, 10), Array(3, 7, 15), Array(5, 12, 12), Array(15, 20, 10), Array(19, 24, 8)),
      List(Array(2, 10), Array(3, 15), Array(7, 12), Array(12, 0), Array(15, 10), Array(20, 8), Array(24, 0)))
  }

  test("sample2") {
    check(Array(Array(0, 2, 3), Array(2, 5, 3)),
      List(Array(0, 3), Array(5, 0)))
  }

  def check(src: Array[Array[Int]], target: List[Array[Int]]): Unit = {
    val res = SkyLine.getSkyline(src)
    res.foreach(p => print(p.toList) + ", ")
    println()
    assert(res.nonEmpty)
    res.zip(target).foreach(arrs => assert(arrs._1 sameElements arrs._2))
  }
}