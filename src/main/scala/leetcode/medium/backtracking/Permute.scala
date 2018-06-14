package leetcode.medium.backtracking

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
  *
  * 给定一个没有重复数字的序列，返回其所有可能的全排列。
  */
object Permute {
  def permute(nums: Array[Int]): List[List[Int]] = {
    /**
      * 回溯法
      * 从left里面遍历取数,取出的加入到curList,然后递归遍历剩下的left
      *
      * @param left    剩余没遍历的
      * @param curList 当前已遍历的
      * @param result  存储结果
      */
    def combine(left: mutable.Buffer[Int], curList: List[Int], result: List[List[Int]]): List[List[Int]] = {
      if (left.isEmpty) //没有剩余的,可以加进结果集了
        result :+ curList
      else {
        var res = result
        for (i <- left.indices) {
          //本次要取的数
          val cur = left(i)
          left.remove(i)
          res = combine(left, curList :+ cur, res)
          //回溯,恢复前面的影响
          left.insert(i, cur)
        }
        res
      }
    }
    combine(nums.toBuffer, List(), List())
  }
}
