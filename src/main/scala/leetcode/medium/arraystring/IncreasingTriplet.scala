package leetcode.medium.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/80/
  *
  * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
  * 正式的数学表达如下:
  * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
  * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
  * 要求算法时间复杂度为O(n)，空间复杂度为O(1) 。
  */
object IncreasingTriplet {
  /**
    * 用两个变量维护最小值和次小值(仅代表比当前最小值大的数，不是全局的次小)。
    * 遍历数组，如果遇到比次小值大的，那么必然存在三个数满足题目条件（最小值&lt;次小值&lt;当前值）
    */
  def increasingTriplet(nums: Array[Int]): Boolean = {
    var min = Int.MaxValue
    var secondary = Int.MaxValue
    val len = nums.length
    if (len < 3) {
      false
    } else {
      for(i <- 0 until len){
        if(nums(i) <= min){
          min = nums(i)
        }else if(nums(i) <= secondary){
          secondary = nums(i)
        } else {
          return true
        }
      }
      false
    }
  }
}
