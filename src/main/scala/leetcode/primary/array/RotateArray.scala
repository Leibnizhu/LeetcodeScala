package leetcode.primary.array

object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
    /**
      * 翻转数组
      * @param nums 数组
      * @param start 开始下标(包含)
      * @param stop 结束下标(包含)
      */
    def reverse(nums: Array[Int], start: Int, stop: Int): Unit = {
      var l = start
      var r = stop
      while (l < r) {
        val tmp = nums(l)
        nums(l) = nums(r)
        nums(r) = tmp
        l = l + 1
        r = r - 1
      }
    }

    /**
      * 分两段,分别翻转,然后整个数组翻转,空间O(1),时间O(n)
      */
    if (nums != null) {
      val move = k % nums.length
      reverse(nums, 0, nums.length - 1 - move)
      reverse(nums, nums.length - move, nums.length - 1)
      reverse(nums, 0, nums.length - 1)
    }
  }
}
