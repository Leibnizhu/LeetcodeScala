package codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class YourOrderPleaseTest extends AnyFlatSpec with Matchers {

  "order(\"is2 Thi1s T4est 3a\")" should "return \"Thi1s is2 3a T4est\"" in {
    YourOrderPlease.order("is2 Thi1s T4est 3a") should be ("Thi1s is2 3a T4est")
  }
}
