package leetcode.medium.sortsearch

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
  *
  * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
  * 说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
  */
object FindKthLargest {
  /**
    * 堆排序，维护一个大小=k的小根堆
    * 将数组中的每个元素与堆顶元素进行比较:
    *  - 如果比堆顶元素大，则删除堆顶元素并添加该元素
    *  - 如果比堆顶元素小，则什么也不做，继续下一个元素。
    * 时间复杂度O(nlogk)，空间复杂度O(k)。
    */
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val queue = mutable.PriorityQueue.empty(Ordering.by[Int,Int](p=>p).reverse) //利用自带堆,需要设置排序方法
    for(num <- nums){
      if(queue.size < k){
        queue += num
      } else {
        val top =  queue.dequeue()
        queue += (if(num > top) num else top)
      }
    }
    queue.head
  }
}
