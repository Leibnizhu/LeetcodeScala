package leetcode.daily


/**
  * 2022-05-12
  * {@see <a href='https://leetcode.cn/problems/univalued-binary-tree/'/> }
  */
object UnivaluedBinaryTree {
  def isUnivalTree(root: TreeNode): Boolean = isUnival(root, root.value)

  def isUnival(root: TreeNode, v: Int): Boolean = if (root == null) true else
    root.value == v && isUnival(root.left, v) && isUnival(root.right, v)
}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}