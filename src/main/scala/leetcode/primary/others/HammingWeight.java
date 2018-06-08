package leetcode.primary.others;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/64/
 * <p>
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += n & 1;
            n = n >> 1;
        }
        return weight;
    }
}
