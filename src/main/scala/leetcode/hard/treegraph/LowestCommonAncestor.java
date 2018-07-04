package leetcode.hard.treegraph;

import leetcode.medium.design.BinaryTreeCodec.TreeNode;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/139/
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 说明:
 * - 所有节点的值都是唯一的。
 * - p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 又是不准用scala的
 */
class LowestCommonAncestor {
    /**
     * 考虑递归实现.
     * 左子树和右子树分别查找p q的公共祖先,有几种情况:
     * 1. 左子树找到,右子树也找到 => 当前根就是公共祖先
     * 2. 左子树找到,右子树没找到 => 左子树
     * 3. 左子树没找到,右子树找到 => 右子树
     * 3. 左子右子树都没找到 => 找不到
     * 递归的时候,叶子先返回,因此可以拿到最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root; //最终情况,叶子的子节点(无意义返回null),或根节点就是要找的节点之一(找到),都需要直接返回当前根
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left != null ? (right != null ? root : left) : right;
        }
    }
}
