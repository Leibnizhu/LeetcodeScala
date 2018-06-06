package leetcode.primary.tree

object MaxDepth {
  def maxDepth(root: TreeNode): Int = {
    if(root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}
