package leetcode.primary.tree

case class TreeNode (value: Int, var left: TreeNode, var right: TreeNode)

object TreeNode {
  /**
    * 根据传入参数构造数
    *
    * @param nodes 节点数组,null为没有节点,自树根开始按层排列下来(按完全二叉树,没有的补上null)
    * @return 树根
    */
  def buildTree(nodes: Array[Integer]): TreeNode = {
    if (nodes == null || nodes.length == 0) {
      null
    } else {
      val len = min2Power(nodes.length)
      val treeNodes = new Array[TreeNode](len)
      for (i <- 0 until len) {
        val node = if (i < nodes.length) nodes(i) else null
        treeNodes(i) = if (node == null) null else TreeNode(node, null, null)
      }
      /**
        * 给出的数组是按完全二叉树的顺序来的,因此左节点=2i+1,右节点=2(i+1)
        */
      for (i <- 0 until len) {
        if (treeNodes(i) != null) {
          if (2 * i + 1 < len)
            treeNodes(i).left = treeNodes(2 * i + 1)
          if (2 * i + 2 < len)
            treeNodes(i).right = treeNodes(2 * i + 2)
        }
      }
      treeNodes(0)
    }
  }

  /**
    * 常数时间求大于等于cap的最小二次幂
    */
  def min2Power(cap: Int): Int = {
    var n = cap - 1
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
