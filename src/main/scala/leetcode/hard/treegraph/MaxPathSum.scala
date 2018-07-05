package leetcode.hard.treegraph

import java.lang.Math.max

import leetcode.common.TreeNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/140/
  *
  * 给定一个非空二叉树，返回其最大路径和。
  * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
  */
object MaxPathSum {
  /**
    * 这种问题首先想到递归遍历,求左右子树的最大路径和,大于0的对总和有益,则加进去
    * 其实是dfs了
    */
  def maxPathSum(root: TreeNode): Int = {
    /**
      * 递归求解当前根节点下的最大路径和
      * @param cur 当前根节点
      * @param globalMax 当前全局最大路径长度
      * @return (当前子树的最大路径长度, 新的全局最大路径长度)
      */
    def pathDFS(cur: TreeNode, globalMax: Int): (Int, Int) = {
      if (cur == null) {
        (0, globalMax) //叶子节点的左右子树,路径长度为0
      } else {
        val (l, newGlobalMax1) = pathDFS(cur.left, globalMax) //递归计算左子树最大路径和
        val (r, newGlobalMax2) = pathDFS(cur.right, newGlobalMax1) //递归计算右子树最大路径和
        val curSum = cur.value + max(0, l) + max(0, r) //当前树(包含根节点,父节点计算必须包含)路径和
        (cur.value + (if (max(l, r) > 0) max(l, r) else 0), //作为路径,只能选择较大的一个子树的路径
          max(newGlobalMax2, curSum)) //更新全局最大路径和,如果当前根为负,那么子树的计算已经处理了子树的最大值并更新到全局最大
      }
    }

    pathDFS(root, Int.MinValue)._2
  }
}
