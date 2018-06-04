package leetcode.primary.array


/**
  * 给定两个数组，写一个方法来计算它们的交集。
  */
object Intersect {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val sortedNums1 = nums1.sorted
    val sortedNums2 = nums2.sorted
    var result = List[Int]()
    var p1 = 0
    var p2 = 0
    while (p1 < nums1.length && p2 < nums2.length) {
      val n1 = sortedNums1(p1)
      val n2 = sortedNums2(p2)
      if (n1 == n2) {
        result ::= n1
        if(p1 <= nums1.length -1)p1 += 1
        if(p2 <= nums2.length -1)p2 += 1
      } else if (n1 > n2) {
        p2 += 1
      } else {
        p1 += 1
      }
    }
    result.toArray
  }
}
