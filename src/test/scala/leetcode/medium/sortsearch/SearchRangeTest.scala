package leetcode.medium.sortsearch

import org.scalatest.funsuite.AnyFunSuite

class SearchRangeTest extends AnyFunSuite{
  test("[5,7,7,8,8,10], 8"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8,10), 8) sameElements Array(3,4))
  }

  test("[5,7,7,8,8], 8"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8), 8) sameElements Array(3,4))
  }

  test("[5,5,7,7,8,8], 5"){
    assert(SearchRange.searchRange(Array(5,5,7,7,8,8), 5) sameElements Array(0,1))
  }

  test("[5,7,7,8,8,10], 6"){
    assert(SearchRange.searchRange(Array(5,7,7,8,8,10), 6) sameElements Array(-1,-1))
  }
}
