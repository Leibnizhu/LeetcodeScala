package codewars.kyu1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FabergeEasterEggsCrushTestLinearJava {
    private static BigInteger mo = BigInteger.valueOf(998244353);
    private static List<BigInteger> memo = new ArrayList<>();

    static {
        memo.add(BigInteger.ZERO);
        memo.add(BigInteger.ONE);
        for (int i = 2; i <= 80000; i++) {
            memo.add((mo.subtract(mo.divide(BigInteger.valueOf(i)))).multiply(memo.get(mo.intValue() % i)).mod(mo));
        }
    }

    public static BigInteger height(BigInteger n, BigInteger m) {
        if (n.equals(BigInteger.ZERO) || m.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        BigInteger finalM = m.mod(mo);
        BigInteger finalN = n.min(finalM);
        BigInteger curSum = BigInteger.ZERO, prevCombine = BigInteger.ONE;
        for (int i = 1; i <= finalN.intValue(); i++) {
            BigInteger curCombine = prevCombine.multiply(finalM.subtract(BigInteger.valueOf(i - 1))).multiply(memo.get(i)).mod(mo);
            curSum = curSum.add(curCombine).mod(mo);
            prevCombine = curCombine;
        }
        return curSum.mod(mo);
    }
}
