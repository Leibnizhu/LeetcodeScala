package codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite

class BuildAPileOfCubesTest extends AnyFunSuite {

  test("Samples") {
    assert(BuildAPileOfCubes.findNb(4183059834009L) === 2022)
    assert(BuildAPileOfCubes.findNb(24723578342962L) === -1)
    assert(BuildAPileOfCubes.findNb(135440716410000L) === 4824)
    assert(BuildAPileOfCubes.findNb(40539911473216L) === 3568)
    assert(BuildAPileOfCubes.findNb(26825883955641L) === 3218)
  }
}
