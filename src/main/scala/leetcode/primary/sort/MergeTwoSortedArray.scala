package leetcode.primary.sort

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
  *
  * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
  * 说明:
  * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
  * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
  */
object MergeTwoSortedArray {
  /**
    * 合并两个排序数组
    *
    * @param nums1 第一个数组 m以后的都是0,空间足够
    * @param m     第一个数组的长度
    * @param nums2 第二个数组
    * @param n     第二个数组的长度
    */
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    /**
      * 考虑到使用的空间足够小O(1),可以直接在nums1上面进行复制
      * 这样为了避免前面的数被覆盖,应该从后面开始复制
      */
    var p1 = m - 1
    var p2 = n - 1
    var pRes = m + n - 1
    while (p1 >= 0 && p2 >= 0) {
      nums1(pRes) = if (nums1(p1) >= nums2(p2)) {
        p1 -= 1
        nums1(p1 + 1)
      } else {
        p2 -= 1
        nums2(p2 + 1)
      }
      pRes -= 1
    }
    //num1的游标可以不管,因为旧的数据已经在上面,无需复制了
    while (p2 >= 0) {
      nums1(pRes) = nums2(p2)
      pRes -= 1
      p2 -= 1
    }
  }
}
