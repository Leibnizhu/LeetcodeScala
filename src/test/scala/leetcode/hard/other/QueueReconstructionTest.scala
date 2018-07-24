package leetcode.hard.other

import org.scalatest.FunSuite

class QueueReconstructionTest extends FunSuite {
  test("sample1") {
    val res = QueueReconstruction.reconstructQueue(Array(
      Array(7,0), Array(4,4), Array(7,1), Array(5,0), Array(6,1), Array(5,2)
    ))
    res.foreach(p => print(p.toList +", "))
    println()
    res.zip(Array(
      Array(5,0), Array(7,0), Array(5,2), Array(6,1), Array(4,4), Array(7,1)
    )).forall(a => a._1 sameElements a._2)
  }

  test("sample2"){
    val res = QueueReconstruction.reconstructQueue(Array(
     Array(8,2),Array(4,2),Array(4,5),Array(2,0),Array(7,2),Array(1,4),Array(9,1),Array(3,1),Array(9,0),Array(1,0)
    ))
    res.foreach(p => print(p.toList +", "))
    println()
    res.zip(Array(
      Array(1,0),Array(2,0),Array(9,0),Array(3,1),Array(1,4),Array(9,1),Array(4,2),Array(7,2),Array(8,2),Array(4,5)
    )).forall(a => a._1 sameElements a._2)
  }
}