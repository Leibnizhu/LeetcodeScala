package leetcode.medium.others

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/121/
  *
  * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
  * 你可以假设数组是非空的，并且给定的数组总是存在众数。
  */
object MajorityElement {
  /**
    * 最简单的可以排序,然后取中间位置的数,由于众数次数大于 ⌊ n/2 ⌋ 因此排序后中间位置必然是众数(可以分奇数偶数讨论证明)
    * 这样时间是O(n log(n)),但还可以继续优化
    * 重点考虑众数次数大于 ⌊ n/2 ⌋,还可以O(n)实现,就是遇到不同的数要减掉个数,这样由于众数个数最后,最后会留下来的
    * 具体就是维护当前"众数"及其出现次数,遍历的时候,遇到相同的数,次数++,遇到不同的,次数--,次数为0时用当前的数替代"众数"
    */
  def majorityElement(nums: Array[Int]): Int = {
    var major = nums(0)
    var count = 0
    for(x <- nums){
      if(count == 0){
        major = x
        count = 1
      } else if(major == x){
        count += 1
      } else {
        count -= 1
      }
    }
    major
  }
}
