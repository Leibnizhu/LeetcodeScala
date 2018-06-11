package leetcode.primary.tree

import leetcode.common.TreeNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
  *
  * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
  * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
  */
object SortedArrayToBST {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    /**
      * 数组已经排序,那么可以直接处理了
      * 每次取中间的数作为当前子树的树根的值
      * 然后分别调用两边的子数组,作为左右子树
      * 再把左右子树的树根设为当前节点的左右叶子
      * 最后返回当前节点,即当前子树的树根
      *
      * @param values 取值的数组
      * @param left   要处理的数组左下标
      * @param right  要处理的数组右下标
      * @return
      */
    def toBST(values: Array[Int], left: Int, right: Int): TreeNode = {
      val len = right - left
      if (len < 1)
        null
      else {
        //长度奇数的时候,拿到正中间的数,偶数时,拿到中间偏右的值
        // (注意是偏右,如果一直偏左,可能在最后漏掉数)
        val middle = (left + right) / 2
        val cur = TreeNode(values(middle))
        cur.left = toBST(values, left, middle)
        cur.right = toBST(values, middle + 1, right)
        cur
      }
    }

    toBST(nums, 0, nums.length)
  }
}
