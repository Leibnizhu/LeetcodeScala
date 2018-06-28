package leetcode.hard.arraystring

import java.util


/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/132/
  *
  * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
  * 返回滑动窗口最大值。
  *
  * 示例:
  * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
  * 输出: [3,3,5,5,6,7]
  * 解释:
  * 滑动窗口的位置                最大值
  * ---------------               -----
  * [1  3  -1] -3  5  3  6  7       3
  * 1 [3  -1  -3] 5  3  6  7       3
  * 1  3 [-1  -3  5] 3  6  7       5
  * 1  3  -1 [-3  5  3] 6  7       5
  * 1  3  -1  -3 [5  3  6] 7       6
  * 1  3  -1  -3  5 [3  6  7]      7
  * 注意：你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
  * 进阶：你能在线性时间复杂度内解决此题吗？
  */
object SlidingWindowMaximum {
  /**
    * 暴力法超过O(n).
    * 要保证拿到最近k个数的最大值,至少要维护一个数组/队列保存,长度<=k,而且要排序的.
    * 如果要一直保证k个数都是排序的,那每次来一个新的数要O(k)的时间来插入,这样会超时,
    * 又因为我们只要最大值,因此可以插入新值的时候,把队列里比他小的全部删掉,这样只需要O(n)(一个元素只有一次插入和一次或0次删除)
    * 这样队头的元素是最大的,当窗口移动的时候,可能会离开窗口,为了减少计算量,可以在队列里存储下标,这样可以知道是否超过窗口k的范围
    * 于是,插入新数需要在后面删并加,窗口移动需要删掉前面的,所以需要一个双向队列来存储当前窗口的降序排序下标
    * 而遍历的时候队头可以放入结果集,遍历完返回结果集即可
    */
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums == null || nums.isEmpty)
      Array()
    else {
      val deque = new util.LinkedList[Int]() //存储当前窗口的降序排序下标的队列,用链表存储
      val res = new Array[Int](nums.length + 1 - k) //存储结果
      for (i <- nums.indices) {
        //如果队头元素已经离开当前窗口,那么移除掉
        if (!deque.isEmpty && deque.peekFirst() == i - k) deque.poll()
        //从队尾开始,删除比当前的数小的
        while (!deque.isEmpty && nums(deque.peekLast()) < nums(i)) deque.removeLast()
        //加入当前数(的下标)
        deque.offerLast(i)
        //结果集增加当前队头对应的数(当前窗口最大值)
        if (i + 1 >= k) res(i + 1 - k) = nums(deque.peek())
      }
      res
    }
  }
}
