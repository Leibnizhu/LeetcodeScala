package codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec

class MakeTheDeadfishSwimTest extends AnyFlatSpec {
  it should "work with example tests" in {
    assert(MakeTheDeadfishSwim.parse("iiisdoso") == List(8, 64))
    assert(MakeTheDeadfishSwim.parse("iiisdosodddddiso") == List(8, 64, 3600))
  }
}