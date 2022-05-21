package leetcode.hard.other

import org.scalatest.funsuite.AnyFunSuite

class QueueReconstructionTest extends AnyFunSuite {
  test("sample1") {
    check(Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2)),
      Array(Array(5, 0), Array(7, 0), Array(5, 2), Array(6, 1), Array(4, 4), Array(7, 1)))
  }

  test("sample2"){
    check(Array(Array(8, 2), Array(4, 2), Array(4, 5), Array(2, 0), Array(7, 2), Array(1, 4), Array(9, 1), Array(3, 1), Array(9, 0), Array(1, 0)),
      Array(Array(1, 0), Array(2, 0), Array(9, 0), Array(3, 1), Array(1, 4), Array(9, 1), Array(4, 2), Array(7, 2), Array(8, 2), Array(4, 5)))
  }

  def check(src: Array[Array[Int]], target: Array[Array[Int]]): Unit = {
    val res = QueueReconstruction.reconstructQueue(src)
    res.foreach(p => print(p.toList + ", "))
    println()
    res.zip(target).forall(a => a._1 sameElements a._2)
  }
}