package leetcode.daily

import org.scalatest.FunSuite

class StickersToSpellWordTest extends FunSuite {
  test("case1") {
    assertResult(3)(StickersToSpellWord.minStickers(Array("with", "example", "science"), "thehat"))
  }

  test("case2") {
    assertResult(-1)(StickersToSpellWord.minStickers(Array("notice","possible"), "basicbasic"))
  }

  test("case3") {
    assertResult(3)(StickersToSpellWord.minStickers(Array("these","guess","about","garden","him"), "atomher"))
  }
}
