package leetcode.primary.array

object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
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

    if (nums != null) {
      val move = k % nums.length
      reverse(nums, 0, nums.length - 1 - move)
      reverse(nums, nums.length - move, nums.length - 1)
      reverse(nums, 0, nums.length - 1)
    }
  }
}
