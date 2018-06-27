package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/130/
  *
  * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
  * 说明：
  *  - 不能更改原数组（假设数组是只读的）。
  *  - 只能使用额外的 O(1) 的空间。
  *  - 时间复杂度小于 O(n2) 。
  *  - 数组中只有一个重复的数字，但它可能不止重复出现一次。
  */
object FindDuplicate {
  /**
    * 不能改变原数组且常数空间,那么不能先排序了
    * 时间复杂度小于O(n*n),那么不能暴力法
    * 根据题目可以用二分查找,每次计算mid,判断大于mid和小于mid的数字个数,那边多了就是存在重复的数字,缩小范围继续查找
    * 大致可以估算查找log(n)层,每层是n/pow(2,i)的时间,大致时间复杂度是O(n*log(n)),满足题目要求
    *
    * 还有一种O(n)的方法,就是把数组当做链表,每个下标对应的值是下一个节点的下标,那么如果有数字重复,会指向同一个节点,那么即存在环路
    * 通过快慢指针的方法,可以判断出现了环路,找到第一次出现相同节点的地方,那么上一个节点的值就是重复的数字,
    * 由于是单向链表,此时要再遍历一次找到重复的数字,整体时间复杂度还是O(n)
    * 至于如果存在自循环的点或者说不动点,根据题设,也可以证明可以找到重复值的.这个证明不是那么显然,所以就不使用这个方法了
    * 可以参考: http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
    */
  def findDuplicate(nums: Array[Int]): Int = {
    var min = 0 //重复值取值范围的下限
    var max = nums.length - 1 //重复值取值范围的上限
    while (min < max) {
      val mid = min + (max - min) / 2
      if (nums.count(_ <= mid) <= mid) min = mid + 1 else max = mid
    }
    min
  }
}
