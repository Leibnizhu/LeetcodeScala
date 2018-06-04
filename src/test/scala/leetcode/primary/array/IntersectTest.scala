package leetcode.primary.array

import org.scalatest.FunSuite

class IntersectTest extends FunSuite{
  test("[1, 2, 2, 1], [2, 2]"){
    val nums1 = Array(1, 2, 2, 1)
    val nums2 = Array(2, 2)
    val result = Intersect.intersect(nums1, nums2)
    assert(result(0) == 2)
    assert(result(1) == 2)
  }

}
