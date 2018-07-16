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
    * 外部调用时k传入nums的长度一半(考虑到奇偶长度的情况,应该是(length+1)/2)
    * 任选基准mid,通过filter把nums分为小于mid(下简称左),等于mid(下简称中),大于mid三部分(下简称右)
    * 如果左的个数小于等于k,证明中位数应该在中或右里面,进一步判断中的范围是否覆盖k(中位数)位置,包含则返回mid,否则在右边递归找
    * 如果左的个数大于k,则中位数在左里面,则递归在左边找
    */
  def findKth(nums: Array[Int], k: Int): Int = {
    val mid = nums(0) //比较的基准
    val left = nums.filter(_ < mid)
    val right = nums.filter(_ > mid)
    val midLeft = k - nums.length + right.length //左边和中间去掉k位之后剩余个数
    if (left.length <= k) //左的个数小于等于k,证明中位数应该在中或右里面
      if (midLeft <= 0) mid else findKth(right, midLeft)
    else
      findKth(left, k)
  }

  /**
    * 最直观的方法是升序排序,然后分别交换下标1和2,3和4,....的数字,但是显然需要O(n*log n)时间,不满足进阶要求
    * 仔细考虑发现排序不是必须的,只要找到中位数M(可以做到O(n)),就可以把比M大和小的数分别放在奇偶下标位置上,可以满足题目条件
    * 进一步细化,就是数组长度len为奇数的时候,比M小的放在0,2...位置，比M大的放在len-2...位置；
    * 若len为偶数，把比M小的依次放在len-2,len-4,...位置，比M大的依次放在1,3,...位置;剩余位置放M
    */
  def wiggleSort(nums: Array[Int]): Unit = {
    val len = nums.length
    val mid = findKth(nums, (len + 1) / 2)
    val res = Array.fill(len)(mid) //结果数组, 默认剩余位置填充中位数
    val even = len % 2 == 0
    var l = if (even) len - 2 else 0
    var r = if (even) 1 else len - 2
    nums.filter(_ < mid).foreach(n => {
      res(l) = n
      l += (if (even) -2 else 2)
    })
    nums.filter(_ > mid).foreach(n => {
      res(r) = n
      r += (if (even) 2 else -2)
    })
    Array.copy(res, 0, nums, 0, len) //结果复制到原数组
  }
}
