package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/126/
  *
  * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
  * 注意：你不能倾斜容器，n 至少是2。
  */
object MaxArea {
  /**
    * 问题就是max{min(ai,aj)*|ai-aj|}, i,j∈[1,n]
    * 暴力穷举是O(n*n),实际上可以通过头尾指针缩小范围
    * 另外题目只要求返回最大容量,因此只需要记录当前最大容量即可,具体的ai,aj无需记录
    */
  def maxArea(height: Array[Int]): Int = {
    var l = 0
    var r = height.length - 1
    var contain = 0 //记录最大容量
    while (l < r) {
//      println(l,r,height(l),height(r),(r - l) * Math.min(height(l), height(r)))
      contain = Math.max(contain, (r - l) * Math.min(height(l), height(r))) //更新最大容量
      if (height(r) > height(l)) l += 1 else r -= 1
    }
    contain
  }
}
