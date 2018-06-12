package leetcode.medium.treegraph

import leetcode.common.TreeNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/87/
  *
  * 根据一棵树的前序遍历与中序遍历构造二叉树。
  * 注意:
  * 你可以假设树中没有重复的元素。
  */
object BuildTree {
  /**
    * 可以递归处理
    * 前序遍历的第一个元素肯定是当前子树的根,
    * 确定根只有,由于树中无重复元素,所以直接在中序里面查找根的位置,前面的就是左子树的中序,后面的就是右子树的中序
    * 而中序的最后一个元素必然与前序的最后一个元素相同,所以用左子树的中序的最后一个元素,在前序中查找,也可以确定左右子树的前序.
    * 然后递归调用,获得左右子树的根,给当前子树的根设置上,返回即可
    */
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    /**
      * 通过前序和中序遍历构造树,需要递归调用
      *
      * @param preOrder 前序遍历数组
      * @param preBegin 当前子树的前序开始下标
      * @param preEnd   当前子树的前序结束下标 不包含
      * @param inOrder  中序遍历数组
      * @param inBegin  当前子树的中序开始下标
      * @param inEnd    当前子树的中序结束下标 不包含
      * @return 当前子树的根
      */
    def build(preOrder: Array[Int], preBegin: Int, preEnd: Int,
              inOrder: Array[Int], inBegin: Int, inEnd: Int): TreeNode = {
      //到叶子节点,则返回
      if (preBegin == preEnd || inBegin == inEnd)
        return null
      val rootValue = preOrder(preBegin)
      val root = TreeNode(rootValue)
      val inOrderRootPos = find(inOrder, inBegin, inEnd, rootValue) //中序里面根的下标
      val leftSize = inOrderRootPos - inBegin //左子树的长度(元素个数)
      root.left = build(preOrder, preBegin + 1, preBegin + leftSize + 1,
        inOrder, inBegin, inBegin + leftSize)
      root.right = build(preOrder, preBegin + leftSize + 1, preEnd,
        inOrder, inOrderRootPos + 1, inEnd)
      root
    }

    if (preorder == null || preorder.isEmpty || inorder == null || inorder.isEmpty)
      null
    else
      build(preorder, 0, preorder.length, inorder, 0, inorder.length)
  }

  /**
    * 在数组arr下标范围begin到end(不包含)内查找target的下标
    */
  def find(arr: Array[Int], begin: Int, end: Int, target: Int): Int = {
    for (i <- begin until end)
      if (arr(i) == target)
        return i
    -1
  }
}
