package leetcode.medium.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
  *
  * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
  * 说明：解集不能包含重复的子集。
  */
object SubSet {
  /**
    * 每个组合数其实就是杨辉三角的一个值,易证明总数量为2^n
    * 换而言之,nums每个元素都可以选择出现或不出现,所有可能性加在一起就是结果^
    */
  def subsets(nums: Array[Int]): List[List[Int]] = {
    /**
      * 构造第n层子集
      *
      * @param n         当前处理到的nums下标
      * @param curSet    当前得到的子集
      * @param curResult 所有子集的结果集
      * @return 所有子集的结果集
      */
    def build(n: Int, curSet: List[Int], curResult: List[List[Int]]): List[List[Int]] =
      if (nums.length == n)
        curResult :+ curSet
      else {
        val tmpRes = build(n + 1, curSet :+ nums(n), curResult) //当前数字选择加入子集
        build(n + 1, curSet, tmpRes) //当前数字选择不加入子集
      }

    if (nums.isEmpty) List() else build(0, List(), List())
  }
}
