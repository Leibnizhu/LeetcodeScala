package leetcode.primary.sort

import org.scalatest.FunSuite

class MergeTwoSortedArrayTest extends FunSuite{
  /**
    * 输入:
    * nums1 = [1,2,3,0,0,0], m = 3
    * nums2 = [2,5,6],       n = 3
    *
    * 输出: [1,2,2,3,5,6]
    */
  test(" [1,2,3], [2,5,6]"){
    val nums1 = Array(1,2,3,0,0,0)
    val nums2 = Array(2,5,6)
    MergeTwoSortedArray.merge(nums1,3,nums2,3)
    assert(nums1 sameElements Array(1,2,2,3,5,6))
  }

  test(" [1,2,3], []"){
    val nums1 = Array(1,2,3)
    val nums2 = Array[Int]()
    MergeTwoSortedArray.merge(nums1,3,nums2,0)
    assert(nums1 sameElements Array(1,2,3))
  }

  test(" [], [2,5,6]"){
    val nums1 = Array(0,0,0)
    val nums2 = Array(2,5,6)
    MergeTwoSortedArray.merge(nums1,0,nums2,3)
    assert(nums1 sameElements Array(2,5,6))
  }
}
