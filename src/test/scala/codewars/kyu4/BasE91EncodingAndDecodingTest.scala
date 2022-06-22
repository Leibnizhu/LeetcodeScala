package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BasE91EncodingAndDecodingTest extends AnyFlatSpec with Matchers {
  "Base91.encode" should "pass fixed tests" in {
    BasE91EncodingAndDecoding.encode("test") should be("fPNKd")
    BasE91EncodingAndDecoding.encode("Hello World!") should be(">OwJh>Io0Tv!8PE")
  }

  "Base91.decode" should "pass fixed tests" in {
    BasE91EncodingAndDecoding.decode("fPNKd") should be("test")
    BasE91EncodingAndDecoding.decode(">OwJh>Io0Tv!8PE") should be("Hello World!")
  }
}
