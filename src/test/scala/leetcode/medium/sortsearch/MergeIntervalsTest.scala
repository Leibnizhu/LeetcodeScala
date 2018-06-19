package leetcode.medium.sortsearch

import leetcode.common.Interval
import org.scalatest.FunSuite

class MergeIntervalsTest extends FunSuite {
  test("[1,3],[2,6],[8,10],[15,18]") {
    val intervals = List(Interval(1, 3), Interval(2, 6), Interval(8, 10), Interval(15, 18))
    val result = MergeIntervals.merge(intervals)
    assert(result == List(Interval(1, 6), Interval(8, 10), Interval(15, 18)))
  }

  test("[1,4],[4,5]") {
    val intervals = List(Interval(1, 4), Interval(4, 5))
    val result = MergeIntervals.merge(intervals)
    assert(result == List(Interval(1, 5)))
  }

  test("[1,3],[4,5]") {
    val intervals = List(Interval(4, 5), Interval(1,3))
    val result = MergeIntervals.merge(intervals)
    assert(result == List(Interval(1, 3), Interval(4,5)))
  }
}
