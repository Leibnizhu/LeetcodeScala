package leetcode.primary.tree

import leetcode.common.TreeNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/49/
  *
  * 给定一个二叉树，检查它是否是镜像对称的。
  * 说明: 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
  */
object IsSymmetric {
  def isSymmetric(root: TreeNode): Boolean = {
    /**
      * 判断两个树是否对称
      * 先处理null的最终情况
      * 然后当前树对称的条件是,两边树根值一样,而且两边的子树,外面的两棵子树对称,里面的两棵子树对称,即:
      *    T1       T2
      *   /  \     /  \
      * T1l  T1r T2l  T2r
      * T1l和T2r对称,T1r和T2l对称
      *
      * @param left  左子树
      * @param right 右子树
      * @return 是否对称
      */
    def isSym(left: TreeNode, right: TreeNode): Boolean =
      if (left == null && right == null)
      //左右都是null,对称,无需继续递归调用
        true
      else if (left == null || right == null)
      //上面已经排除了两边都是null的情况,如果有一边是null另一边不是,则不对称
        false
      else
        left.value == right.value && isSym(left.left, right.right) && isSym(left.right, right.left)

    if (root == null) true else isSym(root.left, root.right)
  }
}
