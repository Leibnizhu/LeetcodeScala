package leetcode.daily

import scala.collection.mutable
import scala.collection.immutable

/**
  * {@see <a href='https://leetcode.cn/problems/stickers-to-spell-word/'/> }
  */
object StickersToSpellWord {
  /*
    * 本质上是完全背包问题
    * target一共有 2^target.length 个子序列
    * memo[i] 记录每个子序列的最小贴纸数
    */
  def minStickers(stickers: Array[String], target: String): Int = {
    def wc(str: String): immutable.Map[Char, Int] =
      str.toCharArray.groupBy(c => c).mapValues(s => s.length)

    def canSpell(stickerWc: Array[immutable.Map[Char, Int]], n: Int, targetWc: immutable.Map[Char, Int]): Boolean =
      targetWc.keySet.subsetOf(stickerWc.take(n).map(_.keySet).foldLeft(Set[Char]())((s, e) => s ++ e))

    val stickerWc = stickers.map(wc)
    val targetWc = wc(target)

    def dp(stickers: Array[String], target: String, memo: Array[Int], mask: Int): Int = {
      val m = target.length
      if (memo(mask) < 0) {
        var res = m + 1
        for (s <- stickers.indices) {
          var left = mask
          val cnt = mutable.Map(stickerWc(s).toSeq: _*)
          for (i <- 0 until target.length) {
            val c = target.charAt(i)
            if (((mask >> i) & 1) == 1 && cnt.getOrElse(c, 0) > 0) {
              cnt(c) -= 1
              left = left ^ (1 << i)
            }
          }
          if (left < mask) {
            res = scala.math.min(res, dp(stickers, target, memo, left) + 1)
          }
        }
        memo(mask) = res
      }
      memo(mask)
    }

    if (!canSpell(stickerWc, stickerWc.length, targetWc)) {
      -1
    } else {
      val m = target.length
      val memo = Array.fill(1 << m)(-1)
      memo(0) = 0
      val res = dp(stickers, target, memo, (1 << m) - 1)
      if (res <= m) res else -1
    }
  }
}
