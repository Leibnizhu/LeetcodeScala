package leetcode.primary.array

/**
  * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
  * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
  */
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    def seek(nums: Array[Int], target: Int, l: Int, r: Int): (Int,Int) = {
      if (l >= r) {
        (r, l)
      } else {
        val sum = nums(l) + nums(r)
        if (sum == target) {
          (l, r)
        } else if (sum < target) {
          seek(nums, target, l + 1, r)
        } else {
          seek(nums, target, l, r - 1)
        }
      }
    }

    /*
     * 排序后,两边分别有游标往中间靠,找到满足条件的位置,最后再在未排序的数组来查找到下标,
     * 排序O(nlogn),找求和O(n),两次找下标O(n),总体O(nlogn)
     */
    val sorted = nums.sorted
    val (l,r) = seek(sorted, target, 0, nums.length - 1)
    Array(nums.indexOf(sorted(l)), nums.lastIndexOf(sorted(r)))
  }
}
