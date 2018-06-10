package leetcode.medium.arraystring

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/75/
  *
  * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
  * 注意：答案中不可以包含重复的三元组。
  */
object ThreeSum {
  /**
    * 遍历前length-2个元素,在后面剩余的数组里面,设置两个游标,向中间逼近
    * 直到找到符合三者和为0的元素,加入到result
    *
    * 长数组在leetcode上可能报超时,改成java才行.也没有别的太好的办法
    */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val result = new ListBuffer[List[Int]]()
    if (nums.length >= 3) {
      val sorted = nums.sorted //排序之后夹逼才有意义
      val target = 0 //这个题目里是0
      for (i <- 0 to nums.length - 3) {
        //相同的没必要再跑一次
        if (i == 0 || sorted(i) != sorted(i - 1)) {
          //设置两个游标夹逼
          var j = i + 1
          var k = sorted.length - 1
          while (j < k) {
            val curSum = sorted(i) + sorted(j) + sorted(k)
            if (curSum < target)
            //比目标小,因为已排序,所以左游标右移
              do j += 1 while (sorted(j) == sorted(j - 1) && j < k)
            else if (curSum > target)
            //比目标大,因为已排序,所以右游标左移
              do k -= 1 while (sorted(k) == sorted(k + 1) && j < k)
            else {
              //等于目标,加入到结果数组,两边夹逼
              result += List(sorted(i), sorted(j), sorted(k))
              do j += 1 while (sorted(j) == sorted(j - 1) && j < k)
              do k -= 1 while (sorted(k) == sorted(k + 1) && j < k)
            }
          }
        }
      }
    }
    result.toList
  }
}
