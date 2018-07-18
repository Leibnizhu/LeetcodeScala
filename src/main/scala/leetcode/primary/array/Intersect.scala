package leetcode.primary.array


/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
  *
  * 给定两个数组，写一个方法来计算它们的交集。
  */
object Intersect {
  /**
    * 两个数组分别排序,然后分别带一个游标从0开始遍历,
    * 找到相同的就是交集的内容,不同的较小者往前走,直到队尾
    */
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    def compare(al: Array[Int], pa: Int)(bl: Array[Int], pb: Int)(curRes: List[Int]): List[Int] =
      if (pa < al.length && pb < bl.length) {
        val (a, b) = (al(pa), bl(pb))
        a - b match {
          case 0 => compare(al, if (pa <= al.length - 1) pa + 1 else pa)(bl, if (pb <= bl.length - 1) pb + 1 else pb)(curRes :+ a)
          case d if d > 0 => compare(al, pa)(bl, pb + 1)(curRes)
          case _ => compare(al, pa + 1)(bl, pb)(curRes)
        }
      } else {
        curRes
      }

    compare(nums1.sorted, 0)(nums2.sorted, 0)(List()).toArray
  }
}
