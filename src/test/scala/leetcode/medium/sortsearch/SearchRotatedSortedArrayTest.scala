package leetcode.medium.sortsearch

import org.scalatest.FunSuite

class SearchRotatedSortedArrayTest extends FunSuite {
  test("[4,5,6,7,0,1,2], target = 0") {
    assert(SearchRotatedSortedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 0) == 4)
  }

  test("[4,5,6,7,0,1,2], target = 3") {
    assert(SearchRotatedSortedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 3) == -1)
  }

  test("[4], target = 4") {
    assert(SearchRotatedSortedArray.search(Array(4), 4) == 0)
  }

  test("[4,1,2], target = 1") {
    assert(SearchRotatedSortedArray.search(Array(4,1,2), 1) == 1)
  }

  test("[7,0,1,2,4,5,6], target = 3") {
    assert(SearchRotatedSortedArray.search(Array(7, 0, 1, 2, 4, 5, 6), 3) == -1)
  }

  test("[8,0,1,2,4,5,6], target = 7") {
    assert(SearchRotatedSortedArray.search(Array(8, 0, 1, 2, 4, 5, 6), 7) == -1)
  }

  test("[7,0,1,2,4,5,6], target = 1") {
    assert(SearchRotatedSortedArray.search(Array(7, 0, 1, 2, 4, 5, 6), 1) == 2)
  }

  test("empty, target = 5") {
    assert(SearchRotatedSortedArray.search(Array(), 5) == -1)
  }
}
