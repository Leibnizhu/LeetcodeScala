package leetcode.hard.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/151/
  *
  * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
  * 说明: 你可以假设所有输入都会得到有效的结果。
  * 进阶: 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
  */
object WiggleSort {
  /**
    * 最直观的方法是升序排序,然后分别交换下标1和2,3和4,....的数字,但是显然需要O(n*log n)时间,不满足进阶要求
    * 仔细考虑发现排序不是必须的,只要找到中位数M(可以做到O(n)),就可以把比M大和小的数分别放在奇偶下标位置上,可以满足题目条件
    * 进一步细化,就是数组长度len为奇数的时候,比M小的放在0,2...位置，比M大的放在len-2...位置；
    * 若len为偶数，把比M小的依次放在len-2,len-4,...位置，比M大的依次放在1,3,...位置;剩余位置放M
    */
  def wiggleSort(nums: Array[Int]): Unit = {
    def findKth(nums: Array[Int], left: Int, right: Int, k: Int): Int = {
      var (l, r) = (left, right)
      val now = nums(l)
      while (l < r) {
        while (l < r && nums(r) >= now) r -= 1
        nums(l) = nums(r)
        while (l < r && nums(l) <= now) l += 1
        nums(r) = nums(l)
      }
      l - left match {
        case `k` => now
        case d if d < k => findKth(nums, l + 1, right, k - (l - left + 1))
        case _ => findKth(nums, left, r - 1, k)
      }
    }

    val len = nums.length
    val tmp = new Array[Int](len)
    Array.copy(nums, 0, tmp, 0, len)
    val mid = findKth(tmp, 0, len - 1, len / 2)
    val res = Array.fill(len)(mid)
    val even = len % 2 == 0
    var l = if (even) len - 2 else 0
    var r = if (even) 1 else len - 2
    for (i <- 0 until len) {
      if (nums(i) < mid) {
        res(l) = nums(i)
        l += (if (even) -2 else 2)
      } else if (nums(i) > mid) {
        res(r) = nums(i)
        r += (if (even) 2 else -2)
      }
    }
    Array.copy(res, 0, nums, 0, len)
  }
}
