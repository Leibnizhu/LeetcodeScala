package leetcode.daily

import scala.collection.mutable

/**
  * 2022-05-19
  * {@see <a href='https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/'/> }
  */
object MinimumMovesToEqualArrayElementsIi {
  /**
    * 只有2个数的时候，[n0,n1]，显然只要移动到 n0和n1之间的数就可以，移动步数为 abs(n0-n1)
    * 因为如果移动到一个比n0 n1都大的数x, 需要移动 2*(x-max(n0,n1)) + abs(n0-n1)； 移动到比n0 n1都小的数亦然，多移动2*(min(n0,n1)-x)
    * 3个数的时候，排序一下，首先根据2个数的结论，肯定要移动到3个数最大和最小的之间，考虑到中间的数，如果移到中间的数，中间的数就不用移动，这样移动步数最少
    * 4个数的时候，同理，排序[n0,n1,n2,n3], 考虑[n0,n3]，移动到n0,n3之间，考虑[n1,n2],移到n1,n2之间，而因为排序了，[n1,n2]是[n0,n3]子区间，那么要移动到n1,n2之间即可
    * 依次类推，如果nums的个数n是奇数，移动到排序后 第 n/2 (下标从0开始算)个数
    * 如果nums的个数n是偶数，移动到排序后第 n/2-1 或 n/2 (下标从0开始算)个数之间的数都可以
    * 为了统一，就用排序后第 n/2 个数，总移动步数=sum(abs(nums[i]-nums[nums.length/2]))
    * ------
    * 要求排序后第k个数，最简单就排序，O(nlogn) 时间。
    * 但其实不用完全排序，之前也做过第k个数的题，用类似快排思想即可，也可以最小堆
    */
  def minMoves2(nums: Array[Int]): Int = {
    def findKthLargestByMinHeap(nums: Array[Int], k: Int): Int = {
      val queue = mutable.PriorityQueue.empty(Ordering.by[Int, Int](p => p).reverse) //利用自带的最小堆
      for (num <- nums) {
        if (queue.size < k) {
          queue += num
        } else {
          val top = queue.dequeue()
          queue += (if (num > top) num else top)
        }
      }
      queue.head
    }


    def findKthLargestByQuickSort(nums: Array[Int], k: Int): Int = {
      def swap(i: Int, j: Int): Unit = {
        val tmp = nums(i)
        nums.update(i, nums(j))
        nums.update(j, tmp)
      }

      def partition(l: Int, r: Int): Int = {
        swap(l, util.Random.nextInt(r - l) + l)
        val pivot = nums(l)

        var left = l
        var right = r
        while (left < right) {
          while (left < right && nums(right) <= pivot) right -= 1
          if (left < right) {
            nums.update(left, nums(right))
            left += 1
          }
          while (left < right && nums(left) >= pivot) left += 1
          if (left < right) {
            nums.update(right, nums(left))
            right -= 1
          }
        }
        nums.update(left, pivot)
        left
      }

      var left = 0
      var right = nums.length - 1
      while (left < right) {
        val i = partition(left, right)
        if (i == k - 1) return nums(i)
        else if (i < k - 1) left = i + 1
        else right = i - 1
      }
      nums(left)
    }

    def findKthLargestByScalaSort(nums: Array[Int], k: Int): Int = (nums.sorted).apply(k - 1)

    val target = findKthLargestByQuickSort(nums, nums.length / 2 + 1)
    nums.map(n => math.abs(n - target)).sum
  }
}
