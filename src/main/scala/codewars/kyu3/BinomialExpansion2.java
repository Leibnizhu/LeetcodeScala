package codewars.kyu3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * scala的solution有问题（溢出），先用java实现
 * 2022-05-30
 * {@see <a href='https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b/train/scala'/> }
 */
public class BinomialExpansion2 {
    private static final Pattern binExpPattern = Pattern.compile("\\((-?\\d*)(\\w)([+-]\\d+)\\)\\^(\\d+)");

    /**
     * 二项式公式
     * (a+b)ⁿ=C(n,0)aⁿ+C(n,1)aⁿֿ¹b+C(n,2)aⁿֿ²b²+.+C(n,(n-k))[a^(n-k)]b^k+......+C(n,n)bⁿ
     * 则
     * (ax+b)^n=C(n,0)*a^n*x^n + C(n,1)*a^(n-1)*x^(n-1)*b +.....+ C(n,n)*b^n
     */
    public static String expand(String expr) {
        Matcher matcher = binExpPattern.matcher(expr);
        if (!matcher.find()) {
            return "";
        }
        String g1 = matcher.group(1);
        int a;
        if (g1 == null || g1.isEmpty()) {
            a = 1;
        } else if ("-".equals(g1)) {
            a = -1;
        } else {
            a = Integer.parseInt(g1);
        }
        String x = matcher.group(2);
        Integer b = Integer.parseInt(matcher.group(3));
        Integer n = Integer.parseInt(matcher.group(4));
        List<String> tmp = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            BigInteger c = combine(n, i)
                    .multiply(BigInteger.valueOf((long) Math.pow(a, i)))
                    .multiply(BigInteger.valueOf((long) Math.pow(b, n - i))); //系数
            String xStr; //x项， i次幂
            if (i == 0) {
                xStr = "";
            } else if (i == 1) {
                xStr = x;
            } else {
                xStr = x + "^" + i;
            }
            if (c.equals(BigInteger.ZERO)) {
                //null
            } else if(c.equals(BigInteger.ONE)){
                if(xStr.isEmpty()){
                    tmp.add("1");
                } else {
                    tmp.add(xStr);
                }
            } else if(c.equals(BigInteger.valueOf(-1))){
                if(xStr.isEmpty()){
                    tmp.add("-1");
                } else {
                    tmp.add("-" + xStr);
                }
            } else {
                tmp.add(c + xStr);
            }
        }

        return String.join("+", tmp).replace("+-", "-");
    }

    /**
     * 组合 C(n,m)
     * =(n*(n-1)*....*(n-m+1))/(m*(m-1)*...*1)
     */
    private static BigInteger combine(int n, int m) {
        BigInteger res = new BigInteger("1");
        for (int i = 0; i <= m; i++) {
            res = res.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
