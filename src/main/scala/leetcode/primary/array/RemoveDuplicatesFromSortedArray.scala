package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
  *
  * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
  * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
  */
object RemoveDuplicatesFromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int = {
    /**
      * 遍历, len保存着当前找到的不重复的个数, 找到新的数放到前面
      *
      * @param ar 数组
      * @param len 当前不重复的长度
      * @param i 游标
      * @return 不重复的长度
      */
    def distinct(ar: Array[Int], len: Int, i: Int): Int =
      if (i > ar.length - 1)
        len
      else
        distinct(ar, if (ar(i) != ar(len - 1)) {
          ar(len) = ar(i)
          len + 1
        } else len, i + 1)

    if (nums == null || nums.length == 0) 0 else distinct(nums, 1, 1)
  }
}
