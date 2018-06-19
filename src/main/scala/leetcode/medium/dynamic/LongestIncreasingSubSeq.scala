package leetcode.medium.dynamic

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/107/
  *
  * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
  * 说明:
  *  - 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
  *  - 你算法的时间复杂度应该为 O(n2) 。
  * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
  */
object LongestIncreasingSubSeq {
  /**
    * 这题动态规划不好定义状态方程
    * 从另一方面想,数组慢慢变长的时候,新增加的最后一个数,与原来的最长单调增子序列相比:
    * 如果比子序列最后一个数更大,那么可以加入最长单调增子序列,增加其长度
    * 如果比子序列最后一个数更小,那么应该替换到对应位置,重新开始计算最长子序列,但不用清除原来的序列,这样才能保持最长
    */
  def lengthOfLIS(nums: Array[Int]): Int = {
    /**
      * 在buf的下标first到last元素中查找target应该所在的位置(下界)
      */
    def lowerPos(buf: ListBuffer[Int], first: Int, last: Int, target: Int): Int = {
      var l = first
      var r = last
      while (l != r) {
        val mid = l + (r - l) / 2
        if (target > buf(mid)) l = mid + 1 else r = mid
      }
      l
    }

    if (nums == null || nums.isEmpty) {
      0
    } else {
      val subSeq = new ListBuffer[Int]()
      subSeq += nums(0)
      for (num <- nums) {
        val curPos = lowerPos(subSeq, 0, subSeq.size, num)
        if (curPos >= subSeq.size)
          subSeq += num
        else
          subSeq(curPos) = num
      }
      //    println(subSeq.toList)
      subSeq.length
    }
  }
}
