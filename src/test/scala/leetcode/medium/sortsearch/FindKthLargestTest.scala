package leetcode.medium.sortsearch

import org.scalatest.FunSuite

class FindKthLargestTest extends FunSuite{
  test("[3,2,1,5,6,4] k = 2"){
    assert(FindKthLargest.findKthLargest(Array(3,2,1,5,6,4), 2) == 5)
  }

  test("[3,2,3,1,2,4,5,5,6] k = 4"){
    assert(FindKthLargest.findKthLargest(Array(3,2,3,1,2,4,5,5,6), 4) == 4)
  }
}
