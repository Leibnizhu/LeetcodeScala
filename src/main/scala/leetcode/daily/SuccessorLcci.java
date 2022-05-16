package leetcode.daily;

/**
 * {@see <a href='https://leetcode.cn/problems/successor-lcci/'/> }
 */
public class SuccessorLcci {
    /**
     * 考虑条件的BST，中序遍历应该是自增的，找p的hzji后继，其实就是要找val >= p 的node
     * 从 root 开始遍历node：
     * 1. 如果node 的 val > p ,那么p的后继应该是node或者在node的左子树中（不会在右子树，右子树都比node的值大），记录node，遍历左子树
     * 2. 如果node 的 val <= p,那么p的后继在node的右子树（如果存在后继），遍历右子树
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                result = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
