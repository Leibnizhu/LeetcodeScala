package leetcode.hard.other

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/167/
 * 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
object TrappingRain {
  /**
   * 根据木桶原理,一个点上可以接多少雨水,取决于它左右两边最高点的较小值
   * 所以最简单的方法,可以遍历每个点,找其左右的最大值
   * 
   * 优化一下可以变成扫两边,第一次从左到右遍历,找每个点左边的最大值,
   * 第二次从右到左遍历找每个点右边的最大值,最后扫一遍每个点左右最大值取较小者,减去当前高度,相加
   * 
   * 还可以进一步优化,左的右边最大值和右边的左边最大值,其实是会重复的
   * 可以找到整个数组的最大值,对其左边的子数组,从左到右遍历找左边最大值(右边最大值就是数组最大值),同时累加雨水
   * 对右边子数组,也是从有道做遍历找右边最大值(左边最大值就是数组最大值),同时累加雨水
   */
    def trap(height: Array[Int]): Int = {
      val peakIndex = (0/:height.indices) {(curMax, i) => if(height(i) > height(curMax)) i else curMax} //数组最大值的下标
      val leftWater = (0 until peakIndex).foldLeft((0, 0)) { case((leftPeak, water), i) =>
        if (height(i) > leftPeak) (height(i), water) //更新左峰值,此时当前节点不可能接到雨水
        else (leftPeak, water + leftPeak - height(i)) //当前点接的雨水统计
      }._2 //左边接到的雨水
      (height.length - 1 until peakIndex by -1).foldLeft((0, leftWater)) { case((rightPeak, water), i) => 
        if (height(i) > rightPeak) (height(i), water) //更新右峰值,此时当前节点不可能接到雨水
        else (rightPeak, water + rightPeak - height(i)) //当前点接的雨水统计
      }._2 //总接到雨水
    }
}