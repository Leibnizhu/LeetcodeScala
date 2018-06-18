package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
  *
  * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
  * 你的算法时间复杂度必须是 O(log n) 级别。
  * 如果数组中不存在目标值，返回 [-1, -1]。
  */
object SearchRange {
  /**
    * 已排序,而且要求时间复杂度必须是 O(log n) 级别,因此二分查找
    * 但这里target可能有多个,需要找出下标范围,因此需要查两次,一次找最小下标,一次找最大下标
    * 找最小下标的时候,如果区间中间值匹配到了,不能停,要继续在左区间查找
    * 同理,找最大小标,中间值匹配到后要在右区间找
    */
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    /**
      * @param f (中间值,目标值)=>是否进入右区间查找
      * @return 最后回合的下标
      */
    def binarySearch(arr: Array[Int])(f: (Int, Int) => Boolean): Int = {
      var l = 0
      var r = arr.length
      while (l != r) {
        val mid = l + (r - l) / 2
        if (f(arr(mid), target))
          l = mid + 1
        else
          r = mid
      }
      l
    }

    val lower = binarySearch(nums)(_ < _)
    val upper = binarySearch(nums)(_ <= _)
    if (lower == nums.length || nums(lower) != target)
      Array(-1, -1)
    else
      Array(lower, upper - 1)
  }
}
