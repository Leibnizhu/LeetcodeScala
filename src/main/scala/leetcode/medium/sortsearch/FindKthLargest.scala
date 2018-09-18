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

  def findKthLargest2(nums: Array[Int], k: Int): Int = {
    def findKth(nums: Array[Int], k: Int)(left:Int, right:Int): Int = {
      if(left == right && k == 1) {
        nums(left)
      } else {
        //快排 partition
        var i = left
        var j = right
        println(s"call l:$left,r=$right,k=$k")
        val pivot = nums(left)
        while(i < j){
          while(i < j && nums(j) >= pivot) j -= 1
          nums(i) = nums(j)
          while(i < j && nums(i) <= pivot) i += 1
          nums(j) = nums(i)
        }
        nums(i) = pivot
        val largerSize = right - i + 1
        println(s"l:$left,r=$right,pivot=$pivot,pos=$i,largerSize=$largerSize,nums:${nums.toList}")
        if(largerSize == k){
          nums(i)
        } else if (largerSize < k) {
          findKth(nums, k - largerSize)(left, i - 1)
        } else {
          findKth(nums, k)(i + 1, right)
        }
      }
    }
    findKth(nums, k)(0, nums.length-1)
  }
}
