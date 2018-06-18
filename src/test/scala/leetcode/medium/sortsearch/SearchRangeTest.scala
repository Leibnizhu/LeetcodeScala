package leetcode.medium.sortsearch

import org.scalatest.FunSuite

class SearchRangeTest extends FunSuite{
  test("[5,7,7,8,8,10], 8"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8,10), 8) sameElements Array(3,4))
  }

  test("[5,7,7,8,8], 8"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8), 8) sameElements Array(3,4))
  }

  test("[5,7,7,8,8,10], 6"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8,10), 6) sameElements Array(-1,-1))
  }
}
