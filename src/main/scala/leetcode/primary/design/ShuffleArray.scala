package leetcode.primary.design

import scala.util.Random

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
  *
  * 打乱一个没有重复元素的数组。
 *
  * @param _nums 原始数组
  */
class ShuffleArray (_nums: Array[Int]) {
  val len = _nums.length
  val origin = new Array[Int](len)
    _nums.copyToArray(origin)

  /** Resets the array to its original configuration and return it. */
  def reset(): Array[Int] = {
    origin.copyToArray(_nums)
    _nums
  }

  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    val rand = new Random()
    for(i <- _nums.indices){
      val tmp = _nums(i)
      val randInx = rand.nextInt(len)
      _nums(i) = _nums(randInx)
      _nums(randInx) = tmp
    }
    _nums
  }
}
