package leetcode.primary.others

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/69/
  *
  * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
  * 说明: 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
  */
object FindMissingNumber {
  /**
    * 数组求和,跟全满的数组相减就知道少了哪个
    * 如果是缺了最后一个,相减应该==0,那么返回最大的数即可
    * 如果缺了0,相减也是0,那么应该判断最小值
    */
  def missingNumber(nums: Array[Int]): Int = {
    val max = nums.length //数组中应该最大的值
    val total = max * (max + 1) / 2 //如果数组全满了,应该有的总和
    val delta = total - nums.sum //差值
    if (delta == 0)
      if (nums.min > 0) 0 else max
    else delta
  }
}
