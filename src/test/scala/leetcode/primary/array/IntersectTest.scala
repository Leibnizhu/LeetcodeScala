package leetcode.primary.array

import org.scalatest.funsuite.AnyFunSuite

class IntersectTest extends AnyFunSuite{
  test("[1, 2, 2, 1], [2, 2]"){
    val nums1 = Array(1, 2, 2, 1)
    val nums2 = Array(2, 2)
    val result = Intersect.intersect(nums1, nums2)
    assert(result(0) == 2)
    assert(result(1) == 2)
  }

  test("[1, 3], [2,4,1]") {
    val nums1 = Array(1, 3)
    val nums2 = Array(2, 4, 1)
    val result = Intersect.intersect(nums1, nums2).sorted
    assert(result(0) == 1)
  }

  test("contain -2147483648") {
    val nums1 = Array(-2147483648, 1, 2, 3)
    val nums2 = Array(1, -2147483648, -2147483648)
    val result = Intersect.intersect(nums1, nums2).sorted
    assert(result(0) == -2147483648)
    assert(result(1) == 1)
  }
}
