package leetcode.medium.sortsearch

import leetcode.common.Interval

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/101/
  *
  * 给出一个区间的集合，请合并所有重叠的区间。
  * 区间 [1,4] 和 [4,5] 可被视为重叠区间。
  */
object MergeIntervals {
  def merge(intervals: List[Interval]): List[Interval] = {
    /**
      * 往现有区间集合buffer(默认已排序)插入一个新区间newInterval
      */
    def insert(buffer: ListBuffer[Interval], newInterval: Interval): Unit = {
      var i = 0
      while (i < buffer.size) {
        val cur = buffer(i)
        if (newInterval.end < cur.start) {
          //当前区间与新区间无交集,且整体大于新区间,则插入新区间并返回
          buffer.insert(i, newInterval)
          return
        } else if (newInterval.start > cur.end) {
          //当前区间与新区间无交集,且整体小于新区间,则继续遍历下一个区间
          i += 1
        } else {
          //当前区间与新区间有交集,则扩展新区间,并将当前区间移除掉(已合并到新区间)
          newInterval.start = Math.min(cur.start, newInterval.start)
          newInterval.end = Math.max(cur.end, newInterval.end)
          buffer.remove(i)
        }
      }
      buffer += newInterval //能跑到这里的都是新区间合并旧区间集合最后一个区间的,则将新区间插入
    }

    val result = ListBuffer[Interval]()
    intervals.foreach(insert(result, _))
    result.toList
  }
}
