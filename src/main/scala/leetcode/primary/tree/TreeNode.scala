package leetcode.primary.tree

case class TreeNode (value: Int, var left: TreeNode = null, var right: TreeNode = null)

object TreeNode {
  /**
    * 根据传入参数构造数
    *
    * @param arr 节点数组,null为没有节点,自树根开始按层排列下来(按完全二叉树,没有的补上null)
    * @return 树根
    */
  def apply(arr: Array[Integer]): TreeNode = {
    if (arr == null || arr.length == 0) {
      null
    } else {
      val len = arr.length
      val nodes = arr.map {
        case value: Integer => TreeNode(value)
        case _ => null
      }
      /**
        * 给出的数组是按完全二叉树的顺序来的,因此左节点=2i+1,右节点=2(i+1)
        */
      nodes.zipWithIndex.foreach { case (node, index) =>
        if (index * 2 + 1 < len && node != null) node.left = nodes(index * 2 + 1)
        if (index * 2 + 2 < len && node != null) node.right = nodes(index * 2 + 2)
      }
      if (nodes.nonEmpty)
        nodes.head
      else
        null
    }
  }

  /**
    * 判断高度平衡二叉树
    * 一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    *
    * 当前节点两个子树高度相差不超过1,且两个子树都是高度平衡二叉树(递归)
    */
  def isHighlyBalancedTree(root: TreeNode): Boolean = {
    if(root == null) true else
    Math.abs(MaxDepth.maxDepth(root.left) - MaxDepth.maxDepth(root.right)) <= 1 &&
      isHighlyBalancedTree(root.left) && isHighlyBalancedTree(root.right)
  }

  /**
    * 常数时间求大于等于cap的最小二次幂
    */
  private def min2Power(size: Int): Int = {
    var n = size - 1
    n |= n >>> 1
    n |= n >>> 2
    n |= n >>> 4
    n |= n >>> 8
    n |= n >>> 16
    if (n < 0) 1
    else if (n >= (1 << 30)) 1 << 30
    else n + 1
  }
}
