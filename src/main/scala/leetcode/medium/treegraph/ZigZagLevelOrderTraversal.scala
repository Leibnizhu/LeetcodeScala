package leetcode.medium.treegraph

import leetcode.common.TreeNode

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/86/
  *
  * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
  */
object ZigZagLevelOrderTraversal {
  /**
    * 类似按层次遍历,每一层插入的时候根据深度改变插入的方向
    */
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    def traverse(cur: TreeNode, depth: Int, res: ListBuffer[ListBuffer[Int]]): Unit = {
      if (cur != null) { // null的情况即叶子下一级,不考虑
        if (depth > res.size) res += ListBuffer[Int]() //增加新List
        //当前节点的值放入对应深度的一维List
        if (depth % 2 == 1) {
          //奇数层从左到右
          res(depth - 1) += cur.value
        } else {
          //偶数层从右到左
          res(depth - 1).insert(0, cur.value)
        }
        traverse(cur.left, depth + 1, res)
        traverse(cur.right, depth + 1, res)
      }
    }

    var result: ListBuffer[ListBuffer[Int]] = ListBuffer()
    traverse(root, 1, result)
    result.map(_.toList).toList
  }
}
