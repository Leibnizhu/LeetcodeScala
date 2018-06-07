package leetcode.primary.array

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
  *
  * 给定一个整数数组，判断是否存在重复元素。
  * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
  */
object ContainsDuplicate {
  /**
    * 直接用HashSet存储,判断size即可,O(n)
    */
  def containsDuplicate(nums: Array[Int]): Boolean = {
    if (nums == null)
      false
    else {
      val set = mutable.HashSet[Int]()
      for (num <- nums)
        set.add(num)
      set.size != nums.length
    }
  }
}
