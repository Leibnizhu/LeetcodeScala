package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/128/
  *
  * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
  * 说明:
  * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
  */
object FirstMissingPositive {
  /**
    * 要求时间复杂度应为O(n),那么如果n不大的话,可以遍历数组找最大值,建立长度为最大值的数组,再遍历一次,遍历到的数在数组对应下标置1,最后再从下标0开始,找到数组里第一个为0的下标
    * 优化一下可以用hash取代这个数组,但这样空间复杂度也为O(n)
    * 所以要考虑在原数组处理,用 交换位置 替代在新数组/hash中存储的过程
    * 即遍历的时候,如果不满足 nums[i]==i+1 条件,在允许的情况下,交换nums[i]和nums[nums[i]-1],即nums[i]换到他应该在的地方
    */
  def firstMissingPositive(nums: Array[Int]): Int = {
    val n = nums.length
    for (i <- nums.indices)
      while (nums(i) > 0 && nums(i) <= n && nums(i) != nums(nums(i) - 1)) { //交换nums[i]和nums[nums[i]-1]
        val tmp = nums(i)
        nums(i) = nums(tmp - 1)
        nums(tmp - 1) = tmp
      }
    //从头遍历找到第一个不满足 nums[i]==i+1 条件的数
    for (i <- nums.indices)
      if (nums(i) != i + 1)
        return i + 1
    n + 1 //如果遍历数组找不到不满足条件的,那么数组里有1,2...,n,就是缺n+1了
  }
}
