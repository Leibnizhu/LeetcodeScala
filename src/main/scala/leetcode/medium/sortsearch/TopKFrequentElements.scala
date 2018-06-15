package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
  *
  * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
  * 注意：
  *  - 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
  *  - 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
  */
object TopKFrequentElements {
  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    nums.groupBy(p=>p).map(p=>(p._1, p._2.count(_=>true))).toList.
      sortBy(_._2).reverse.take(k).map(_._1)
  }
}
