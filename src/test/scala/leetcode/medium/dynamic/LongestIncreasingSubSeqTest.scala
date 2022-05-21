package leetcode.medium.dynamic

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer
import scala.util.Random

class LongestIncreasingSubSeqTest extends AnyFunSuite {
  test("10,9,2,5,3,7,101,18") {
    assert(LongestIncreasingSubSeq.lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)) == 4)
  }

  test("1,2,3,4") {
    assert(LongestIncreasingSubSeq.lengthOfLIS(Array(1, 2, 3, 4)) == 4)
  }

  test("4,3,2,1") {
    assert(LongestIncreasingSubSeq.lengthOfLIS(Array(4, 3, 2, 1)) == 1)
  }

  test("random") {
    val rand = new Random()
    val len = rand.nextInt(10) + 1
    val buf = new ListBuffer[Int]()
    for (i <- 0 until len) buf += rand.nextInt(100)
    println(buf.toList)
    LongestIncreasingSubSeq.lengthOfLIS(buf.toArray)
  }

  test("null"){
    assert(LongestIncreasingSubSeq.lengthOfLIS(null) == 0)
  }

  test("empty"){
    assert(LongestIncreasingSubSeq.lengthOfLIS(Array()) == 0)
  }

  test("999"){
    assert(LongestIncreasingSubSeq.lengthOfLIS(Array(999)) == 1)
  }
}
