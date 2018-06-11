package leetcode.primary.tree

import leetcode.common.TreeNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
  *
  * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
  * 一个二叉搜索树具有如下特征：
  * 节点的左子树只包含小于当前节点的数。
  * 节点的右子树只包含大于当前节点的数。
  * 所有左子树和右子树自身必须也是二叉搜索树。
  */
object IsValidBST {
  def isValidBST(root: TreeNode): Boolean = {
    /**
      * 递归,满足BST的条件:左树是bst,右树是bst,当前节点在min max 范围内
      *
      * @param cur 当前节点
      * @param min 当前最小值(不包含)
      * @param max 当前最大值(不包含)
      * @return 当前节点下面的树是否二叉搜索树
      */
    def isBinarySearchTree(cur: TreeNode, min: Long, max: Long): Boolean =
      if (cur == null) true else
        cur.value > min && cur.value < max && isBinarySearchTree(cur.left, min, cur.value) && isBinarySearchTree(cur.right, cur.value, max)
    isBinarySearchTree(root, Int.MinValue - 1L , Int.MaxValue + 1L)
  }
}
