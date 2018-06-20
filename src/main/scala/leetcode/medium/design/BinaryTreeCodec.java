package leetcode.medium.design;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/52/design/109/
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class BinaryTreeCodec {
    private static final String SPLITOR = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    //前序遍历,按完全二叉树来记录,空的记为#,节点之间用逗号隔开
    public String serialize(TreeNode root) {
        if (root == null)
            return NULL + SPLITOR;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(SPLITOR);
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(SPLITOR), new AtomicInteger(-1));
    }

    private TreeNode deserialize(String[] nums, AtomicInteger index) {
        index.addAndGet(1);
        TreeNode leave = null;
        if (index.get() < nums.length && !nums[index.get()].equals("#")) {
            leave = new TreeNode(Integer.valueOf(nums[index.get()]));
            leave.left = deserialize(nums, index);
            leave.right = deserialize(nums, index);
        }
        return leave;
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
