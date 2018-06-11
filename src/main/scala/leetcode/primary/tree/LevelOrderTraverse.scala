package leetcode.primary.tree

import leetcode.common.TreeNode

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
  *
  * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
  */
object LevelOrderTraverse {
  /**
    * 从树根开始递归,传入存储结果的二维List和深度
    * 深度-1对应二维List的第一层下标
    * 递归的时候先把当前节点的值放入对应深度的一维List
    * 然后递归调用左右子树的,深度+1
    *
    * @param root
    * @return
    */
  def levelOrder(root: TreeNode): List[List[Int]] = {
    def traverse(cur: TreeNode, depth: Int, res: ListBuffer[ListBuffer[Int]]): Unit = {
      if (cur != null) { // null的情况即叶子下一级,不考虑
        if (depth > res.size) res += ListBuffer[Int]() //增加新List
        res(depth - 1) += cur.value //当前节点的值放入对应深度的一维List
        traverse(cur.left, depth + 1, res)
        traverse(cur.right, depth + 1, res)
      }
    }

    var result: ListBuffer[ListBuffer[Int]] = ListBuffer()
    traverse(root, 1, result)
    result.map(_.toList).toList
  }
}
