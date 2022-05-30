package codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BinomialExpansionTest extends AnyFlatSpec with Matchers {
  "random test" should "pass" in {
    println(BinomialExpansion.expand("(94y+61)^10"))
  }

  "Fixed Tests" should "pass when constant is positive" in {
    assert("x+1" == BinomialExpansion.expand("(x+1)^1"), "For Input: (x+1)^1")
    assert("x^2+2x+1" == BinomialExpansion.expand("(x+1)^2"), "For Input: (x+1)^2")
    assert("x^3+3x^2+3x+1" == BinomialExpansion.expand("(x+1)^3"), "For Input: (x+1)^3")
    assert("x^4+4x^3+6x^2+4x+1" == BinomialExpansion.expand("(x+1)^4"), "For Input: (x+1)^4")
    assert("x^5+5x^4+10x^3+10x^2+5x+1" == BinomialExpansion.expand("(x+1)^5"), "For Input: (x+1)^5")
    assert("1" == BinomialExpansion.expand("(x+2)^0"), "For Input: (x+2)^0")
    assert("x+2" == BinomialExpansion.expand("(x+2)^1"), "For Input: (x+2)^1")
    assert("x^2+4x+4" == BinomialExpansion.expand("(x+2)^2"), "For Input: (x+2)^2")
    assert("x^3+6x^2+12x+8" == BinomialExpansion.expand("(x+2)^3"), "For Input: (x+2)^3")
    assert("x^4+8x^3+24x^2+32x+16" == BinomialExpansion.expand("(x+2)^4"), "For Input: (x+2)^4")
    assert("x^5+10x^4+40x^3+80x^2+80x+32" == BinomialExpansion.expand("(x+2)^5"), "For Input: (x+2)^5")
    assert("t^5+10t^4+40t^3+80t^2+80t+32" == BinomialExpansion.expand("(t+2)^5"), "For Input: (t+2)^5")
    assert("y^15+75y^14+2625y^13+56875y^12+853125y^11+9384375y^10+78203125y^9+502734375y^8+2513671875y^7+9775390625y^6+29326171875y^5+66650390625y^4+111083984375y^3+128173828125y^2+91552734375y+30517578125" == BinomialExpansion.expand("(y+5)^15"), "For Input: (y+5)^15")
  }
  they should "pass when constant is negative" in {
    assert("1" === BinomialExpansion.expand("(x-1)^0"), "For Input: (x-1)^0")
    assert("x-1" === BinomialExpansion.expand("(x-1)^1"), "For Input: (x-1)^1")
    assert("x^2-2x+1" === BinomialExpansion.expand("(x-1)^2"), "For Input: (x-1)^2")
    assert("x^3-3x^2+3x-1" === BinomialExpansion.expand("(x-1)^3"), "For Input: (x-1)^3")
    assert("x^4-4x^3+6x^2-4x+1" === BinomialExpansion.expand("(x-1)^4"), "For Input: (x-1)^4")
    assert("x^5-5x^4+10x^3-10x^2+5x-1" === BinomialExpansion.expand("(x-1)^5"), "For Input: (x-1)^5")
    assert("1" === BinomialExpansion.expand("(x-2)^0"), "For Input: (x-2)^0")
    assert("x-2" === BinomialExpansion.expand("(x-2)^1"), "For Input: (x-2)^1")
    assert("x^2-4x+4" === BinomialExpansion.expand("(x-2)^2"), "For Input: (x-2)^2")
    assert("x^3-6x^2+12x-8" === BinomialExpansion.expand("(x-2)^3"), "For Input: (x-2)^3")
    assert("x^4-8x^3+24x^2-32x+16" === BinomialExpansion.expand("(x-2)^4"), "For Input: (x-2)^4")
    assert("x^5-10x^4+40x^3-80x^2+80x-32" === BinomialExpansion.expand("(x-2)^5"), "For Input: (x-2)^5")
    assert("t^5-10t^4+40t^3-80t^2+80t-32" === BinomialExpansion.expand("(t-2)^5"), "For Input: (t-2)^5")
    assert("y^15-75y^14+2625y^13-56875y^12+853125y^11-9384375y^10+78203125y^9-502734375y^8+2513671875y^7-9775390625y^6+29326171875y^5-66650390625y^4+111083984375y^3-128173828125y^2+91552734375y-30517578125" === BinomialExpansion.expand("(y-5)^15"), "For Input: (y-5)^15")
  }

  they should "pass when coefficient is positive" in {
    assert("625m^4+1500m^3+1350m^2+540m+81" === BinomialExpansion.expand("(5m+3)^4"), "For Input: (5m+3)^4")
    assert("8x^3-36x^2+54x-27" === BinomialExpansion.expand("(2x-3)^3"), "For Input: (2x-3)^3")
    assert("1" === BinomialExpansion.expand("(7x-7)^0"), "For Input: (7x-7)^0")
    assert("35831808a^7+20901888a^6+5225472a^5+725760a^4+60480a^3+3024a^2+84a+1" === BinomialExpansion.expand("(12a+1)^7"), "For Input: (12a+1)^7")
    assert("184528125x^5-123018750x^4+32805000x^3-4374000x^2+291600x-7776" === BinomialExpansion.expand("(45x-6)^5"), "For Input: (45x-6)^5")
    assert("12c+1" === BinomialExpansion.expand("(12c+1)^1"), "For Input: (12c+1)^1")
    assert("100000000x^4-4000000x^3+60000x^2-400x+1" === BinomialExpansion.expand("(100x-1)^4"), "For Input: (100x-1)^4")
    assert("1000x^3+2400x^2+1920x+512" === BinomialExpansion.expand("(10x+8)^3"), "For Input: (10x+8)^3")
    assert("128x^7-448x^6+672x^5-560x^4+280x^3-84x^2+14x-1" === BinomialExpansion.expand("(2x-1)^7"), "For Input: (2x-1)^7")
    assert("81t^2" === BinomialExpansion.expand("(9t-0)^2"), "For Input: (9t-0)^2")
  }

  they should "pass when coefficient is negative" in {
    assert("625m^4-1500m^3+1350m^2-540m+81" === BinomialExpansion.expand("(-5m+3)^4"), "For Input: (-5m+3)^4")
    assert("-8k^3-36k^2-54k-27" === BinomialExpansion.expand("(-2k-3)^3"), "For Input: (-2k-3)^3")
    assert("1" === BinomialExpansion.expand("(-7x-7)^0"), "For Input: (-7x-7)^0")
    assert("-35831808a^7+20901888a^6-5225472a^5+725760a^4-60480a^3+3024a^2-84a+1" === BinomialExpansion.expand("(-12a+1)^7"), "For Input: (-12a+1)^7")
    assert("-184528125k^5-123018750k^4-32805000k^3-4374000k^2-291600k-7776" === BinomialExpansion.expand("(-45k-6)^5"), "For Input: (-45k-6)^5")
    assert("-12c+1" === BinomialExpansion.expand("(-12c+1)^1"), "For Input: (-12c+1)^1")
    assert("100000000x^4+4000000x^3+60000x^2+400x+1" === BinomialExpansion.expand("(-100x-1)^4"), "For Input: (-100x-1)^4")
    assert("-1000x^3+2400x^2-1920x+512" === BinomialExpansion.expand("(-10x+8)^3"), "For Input: (-10x+8)^3")
    assert("-128w^7-448w^6-672w^5-560w^4-280w^3-84w^2-14w-1" === BinomialExpansion.expand("(-2w-1)^7"), "For Input: (-2w-1)^7")
    assert("-n^5-60n^4-1440n^3-17280n^2-103680n-248832" === BinomialExpansion.expand("(-n-12)^5")); //extra static test added by docgunthr, "For Input://extra static test added by o
    assert("-k^7+28k^6-336k^5+2240k^4-8960k^3+21504k^2-28672k+16384" === BinomialExpansion.expand("(-k+4)^7")); //extra static test added by docgunthr, "For Input://extra static test added by o
    assert("81t^2" === BinomialExpansion.expand("(-9t-0)^2"), "For Input: (-9t-0)^2")
  }
}
