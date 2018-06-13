package leetcode.medium.treegraph

import leetcode.common.TreeNode

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/89/
  *
  * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
  * 说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
  * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
  */
object KthSmallest {
  /**
    * 中序遍历之后的数组就是升序排序的,取k-1个即可
    */
  def kthSmallest(root: TreeNode, k: Int): Int = {
    def traverse(cur: TreeNode, buf: ListBuffer[Int]): Unit = {
      if (cur != null) {
        traverse(cur.left, buf)
        buf += cur.value
        traverse(cur.right, buf)
      }
    }

    val ordered = new ListBuffer[Int]
    traverse(root, ordered)
    ordered(k - 1)
  }
}
