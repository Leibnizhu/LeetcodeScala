package leetcode.primary.tree

case class TreeNode (value: Int, var left: TreeNode, var right: TreeNode)

object TreeNode {
  /**
    * 根据传入参数构造数
    *
    * @param nodes 节点数组,null为没有节点,自树根开始按层排列下来
    * @return 树根
    */
  def buildTree(nodes: Array[Integer]): TreeNode = {
    if (nodes == null || nodes.length == 0) {
      null
    } else {
      None
      val treeNodes = nodes.map(node => if (node == null) null else TreeNode(node, null, null))
      val len = nodes.length
      for (i <- 0 until len) {
        if (2 * i + 1 < len)
          treeNodes(i).left = treeNodes(2 * i + 1)
        if (2 * i + 2 < len)
          treeNodes(i).right = treeNodes(2 * i + 2)
      }
      treeNodes(0)
    }
  }
}
