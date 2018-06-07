package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
  *
  * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
  */
object SingleNumber {
  /**
    * 所有数求异或,重复出现的数会抵消,没有重复出现的数不会被抵消,最后保留下来
    */
  def singleNumber(nums: Array[Int]): Int = (0/:nums)(_^_)
}
