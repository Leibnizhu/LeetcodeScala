package leetcode.medium.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/104/
  *
  * 给定一个非负整数数组，你最初位于数组的第一个位置。
  * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
  * 判断你是否能够到达最后一个位置。
  */
object JumpGame {
  /**
    * 使用动态规划
    * 我们可以设定一个函数f(x)表示下标x的位置里最多还有多少步数可以走
    * 显然:
    * f(x) = A(i) , i==0,即一开始可以有A(0)步可以走
    * f(x) = max(f(x-1) -1, A(i)), i>0 && f(i-1)>0,即第i个位置时,可走的步数,要么用当前可走的,要么是上一格可走的越过了
    * f(x) = 0, i>0 && f(i-1)==0,上一格已经没有剩余步数,到不了这一格,则直接为0
    * 最后返回 f(length -2) > 0即可,即倒数第二位置可走步数>0,可走到最后一个位置
    */
  def canJump(nums: Array[Int]): Boolean = {
    if (nums == null || nums.isEmpty)
      false
    else if (nums.length == 1)
      true
    else {
      val f = new Array[Int](nums.length) //下标x的位置里最多还有多少步数可以走
      for (i <- nums.indices)
        f(i) = if (i == 0) nums(0)
        else if (f(i - 1) > 0) Math.max(f(i - 1) - 1, nums(i))
        else 0
      f(nums.length - 2) > 0
    }
  }
}
