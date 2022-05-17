package leetcode.daily

/**
  * 2022-05-17
  * {@see <a href='https://leetcode.cn/problems/verifying-an-alien-dictionary/'/> }
  */
object VerifyingAnAlienDictionary {
  /**
    * 按字典转换成地球英文，再比较就可以
    * 当然，也可以重写compare方法，直接比较，性能会好点
    */
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val dict = new Array[Int](26)
    order.toCharArray.zipWithIndex.foreach(p => dict(p._1 - 'a') = p._2)
    //偷懒了，直接翻译
    val enWords = words.map(w => new String(w.toCharArray.map(c => (dict(c - 'a') + 'a').toChar)))
    for (i <- 0 until words.length - 1) if (enWords(i + 1) < enWords(i)) return false
    true
  }
}
