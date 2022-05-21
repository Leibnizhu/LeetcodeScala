package leetcode.daily

import scala.collection.mutable

/**
  * 2022-05-21
  * {@see <a href='https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/'/> }
  */
object NRepeatedElementInSize2nArray {
  /**
    * 最简单的跑一遍数组，hash统计下次数,只有有一个数出现2次就可以返回
    * 考虑到只有一个数字重复，可以随机选两个元素对比，相同的就是，相同概率很高
    */
  def repeatedNTimes(nums: Array[Int]): Int = {
    val rand = new util.Random
    val n = nums.length
    while (true) {
      val x = rand.nextInt(n)
      val y = rand.nextInt(n)
      if (x != y && nums(x) == nums(y)) {
        return nums(x)
      }
    }
    -1
  }
}