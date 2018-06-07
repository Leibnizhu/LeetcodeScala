package leetcode.primary.tree

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
  *
  * 给定一个二叉树，找出其最大深度。
  * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
  * 说明: 叶子节点是指没有子节点的节点。
  */
object MaxDepth {
  /**
    * 递归,左右最大深度者加上1即为本层深度,依次迭代
    * 叶子节点的子节点返回0
    *
    * @param root 树根
    * @return 最大深度
    */
  def maxDepth(root: TreeNode): Int = {
    if(root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}
