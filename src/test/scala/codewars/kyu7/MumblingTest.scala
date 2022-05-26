package codewars.kyu7

import org.scalatest.funspec.AnyFunSpec

class MumblingTest extends AnyFunSpec {
  describe("Codewars.accum") {
    it("should work with example tests") {
      assertResult("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu") {
        Mumbling.accum("ZpglnRxqenU")
      }
      assertResult("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb") {
        Mumbling.accum("NyffsGeyylB")
      }
      assertResult("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu") {
        Mumbling.accum("MjtkuBovqrU")
      }
      assertResult("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm") {
        Mumbling.accum("EvidjUnokmM")
      }
      assertResult("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc") {
        Mumbling.accum("HbideVbxncC")
      }
      assertResult("H") {
        Mumbling.accum("H")
      }
      assertResult("") {
        Mumbling.accum("")
      }
    }
  }
}
