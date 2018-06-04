package leetcode.primary.array

import scala.collection.mutable


object ContainsDuplicate {
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
