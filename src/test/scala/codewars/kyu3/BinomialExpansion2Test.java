package codewars.kyu3;

public class BinomialExpansion2Test {
    public static void main(String[] args) {
        testBPositive();
        testBNegative();
        testAPositive();
        testANegative();
    }


    public static void testBPositive() {
        assert "1".equals(BinomialExpansion2.expand("(x+1)^0"));
        assert "x+1".equals(BinomialExpansion2.expand("(x+1)^1"));
        assert "x^2+2x+1".equals(BinomialExpansion2.expand("(x+1)^2"));
    }

    public static void testBNegative() {
        assert "1".equals(BinomialExpansion2.expand("(x-1)^0"));
        assert "x-1".equals(BinomialExpansion2.expand("(x-1)^1"));
        assert "x^2-2x+1".equals(BinomialExpansion2.expand("(x-1)^2"));
    }

    public static void testAPositive() {
        assert "625m^4+1500m^3+1350m^2+540m+81".equals(BinomialExpansion2.expand("(5m+3)^4"));
        assert "8x^3-36x^2+54x-27".equals(BinomialExpansion2.expand("(2x-3)^3"));
        assert "1".equals(BinomialExpansion2.expand("(7x-7)^0"));
    }

    public static void testANegative() {
        assert "625m^4-1500m^3+1350m^2-540m+81".equals(BinomialExpansion2.expand("(-5m+3)^4"));
        assert "-8k^3-36k^2-54k-27".equals(BinomialExpansion2.expand("(-2k-3)^3"));
        assert "1".equals(BinomialExpansion2.expand("(-7x-7)^0"));
    }
}