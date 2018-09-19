package leetcode.medium.design;

public class BinarySearchTreeCodec {
  static final String SPLITOR = ","; //seperate nodes

  /**
   * exmaple: 2 /\ 1 3 serialized: 2,1,3 structure: root, left..., right...
   */
  public String serialize(BSTNode root) {
    StringBuilder sb = new StringBuilder();
    sb.append(root.value).append(SPLITOR);
    if (root.left != null)
      sb.append(serialize(root.left)); // recursive call
    if (root.right != null)
      sb.append(serialize(root.right));
    return sb.toString();
  }

  /**
   * example: 2,,3, deserialized: 2 /\ 1 3
   */
  public BSTNode deserialize(String str) {
    String[] nodes = str.split(SPLITOR);
    return deserialize(nodes, 0, nodes.length - 1);
  }

  /**
   * nodes:all tree nodes begin,end: index range of current tree
   */
  BSTNode deserialize(String[] nodes, int begin, int end) {
    int curRootValue = Integer.parseInt(nodes[begin]);
    BSTNode curRoot = new BSTNode(curRootValue);
    if (begin == end) { // current sub-tree has only root node
      return curRoot;
    }
    int rightTreeStart = begin;
    for (; rightTreeStart <= end && Integer.parseInt(nodes[rightTreeStart]) <= curRootValue; rightTreeStart++) {
      ;
    }
    // rightTreeStart > end(no right tree), or found start index of right tree

    if (rightTreeStart > begin + 1) // has left tree, recursive deserialize left tree
      curRoot.left = deserialize(nodes, begin + 1, rightTreeStart - 1);
    if (end >= rightTreeStart) // has right tree, recursive deserialize right tree
      curRoot.right = deserialize(nodes, rightTreeStart, end);
    return curRoot;
  }

  public static class BSTNode {
    public int value;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int value) {
      this.value = value;
    }
  }
}