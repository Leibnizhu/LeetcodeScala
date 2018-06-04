package leetcode.primary.array

/**
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

    if (nums != null && nums.length != 0) {
      val len = distinct(nums, 0, 0)
      for(i <- len until nums.length) nums(i) = 0
    }
  }
}
