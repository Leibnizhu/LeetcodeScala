package leetcode.medium.treegraph;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/88/
 * <p>
 * 给定一个二叉树
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 说明:
 * - 你只能使用额外常数空间。
 * - 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * - 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 */
public class ConnectTreeNode {
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }

    /**
     * 可以递归,递归的时候应该考虑:
     * 0. 当前节点和其兄弟节点产生connect
     * 1. 当前节点的左树右数产生connect
     * 2. 如果当前节点有右兄弟,则右树跟兄弟的左树应该产生connect
     * 3. 如果当前节点没有右兄弟,那么右树跟null产生connect
     * 0,1为每个节点遍历所必须产生的, 2,3是处理两个子树的connect
     */
    private void connect(TreeLinkNode cur, TreeLinkNode sibling) {
        if(cur == null) //处理叶子节点的下一级
            return;
        //0. 当前节点和其兄弟节点产生connect
        cur.next = sibling;
        //1. 当前节点的左树右数产生connect
        connect(cur.left, cur.right);
        //2. 如果当前节点有右兄弟,则右树跟兄弟的左树应该产生connect
        //3. 如果当前节点没有右兄弟,那么右树跟null产生connect
        connect(cur.right, sibling == null ? null : sibling.left);
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }

        TreeLinkNode(int x, TreeLinkNode l, TreeLinkNode r) {
            val = x;
            left = l;
            right = r;
        }
    }
}
