package leetcode.primary.array

/**
  * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
  */
object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = (0/:nums)(_^_)
}
