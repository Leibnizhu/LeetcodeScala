package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/99/
  *
  * 峰值元素是指其值大于左右相邻值的元素。
  * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
  * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
  * 你可以假设 nums[-1] = nums[n] = -∞。
  * 说明: 你的解法应该是 O(logN) 时间复杂度的。
  */
object FindPeakElement {
  /**
    * 如果不限制时间复杂度那么很简单直接遍历就行,但这里要求O(logn)
    * 这个时间复杂度显然可以考虑二分查找
    * 结合假设 nums[-1] = nums[n] = -∞,可以每次二分
    * 如果中间值的左边值a[mid-1]比中间值a[mid]大,那么左区间必有峰值
    * 因为,如果a[mid-2]小于a[mid-1],那么a[mid-1]就是峰值,否则继续往左边找,就算是单调减,到了a[0]根据定义也是峰值
    * 同理,中间值的右边值a[mid+1]比中间值a[mid]大,那么右区间必有峰值
    * 于是可以递归查下去了
    */
  def findPeakElement(nums: Array[Int]): Int = {
    def binarySearch(nums: Array[Int], l: Int, r: Int): Int = {
      val mid = l + (r - l) / 2
      if ((mid == 0 || nums(mid) >= nums(mid - 1)) && //左边小于中间(包括最左的情况)
        (mid == nums.length - 1 || nums(mid) >= nums(mid + 1))) //右边小于中间(包括最右的情况)
        mid
      else if (mid > 0 && nums(mid - 1) > nums(mid))
        binarySearch(nums, l, mid - 1)
      else
        binarySearch(nums, mid + 1, r)
    }

    binarySearch(nums, 0, nums.length - 1)
  }
}
