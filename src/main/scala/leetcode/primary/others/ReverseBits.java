package leetcode.primary.others;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/66/
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 */
public class ReverseBits {
    /**
     * 两头放游标,交换,然后往里缩
     * 为了减少交换, 可以先判断两头是否一样,一样的话不需要交换
     * 另外两头不一样,交换可以通过对应位上异或1实现
     * 因为,不一样有两种情况
     * 1...0 ^ 1...1 = 0...1
     * 0...1 ^ 1...1 = 1...0
     */
    public int reverseBits(int n) {
        int l = 31;
        int r = 0;
        while (l > r) {
            int x = (n >> l) & 1;
            int y = (n >> r) & 1;
            if (x != y)
                n ^= (1 << l | 1 << r);
            l--;
            r++;
        }
        return n;
    }
}
