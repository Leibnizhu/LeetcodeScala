package leetcode.medium.treegraph

import leetcode.common.TreeNode

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
  *
  * 给定一个二叉树，返回它的中序 遍历。
  * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
  */
object InOrderTraversal {
  def inOrderTraversal(root: TreeNode): List[Int] = {
    def traverse(cur: TreeNode, buffer: ListBuffer[Int]): Unit = {
      if (cur.left != null) traverse(cur.left, buffer)
      buffer.+=(cur.value)
      if (cur.right != null) traverse(cur.right, buffer)
    }

    val result = new ListBuffer[Int]()
    if(root != null) traverse(root, result)
    result.toList
  }
}
