package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
  *
  * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
  */
object MoveZeroes {
  def moveZeroes(nums: Array[Int]): Unit = {
    /**
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
        distinct(ar, if (ar(i) != 0) {
          ar(len) = ar(i)
          len + 1
        } else len, i + 1)

    /**
      * 跟RemoveDuplicatesFromSortedArray类似,判断条件变成找非0的数,
      * 处理完之后非零的数都排在前面,把后面的数全部赋值0即可
      */
    if (nums != null && nums.length != 0) {
      val len = distinct(nums, 0, 0)
      for(i <- len until nums.length) nums(i) = 0
    }
  }
}
