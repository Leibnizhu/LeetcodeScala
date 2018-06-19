package leetcode.medium.sortsearch

import org.scalatest.FunSuite

class SearchSortedMatrixTest extends FunSuite {
  val sample = Array(
    Array(1, 4, 7, 11, 15),
    Array(2, 5, 8, 12, 19),
    Array(3, 6, 9, 16, 22),
    Array(10, 13, 14, 17, 24),
    Array(18, 21, 23, 26, 30)
  )

  test("find each") {
    sample foreach(row =>
      row.foreach(cell =>
        assert(SearchSortedMatrix.searchMatrix(sample, cell))))
  }

  test("find 20") {
    assert(!SearchSortedMatrix.searchMatrix(sample, 20))
  }

  test("null"){
    assert(!SearchSortedMatrix.searchMatrix(null, 20))
  }

  test("all empty"){
    assert(!SearchSortedMatrix.searchMatrix(Array(), 20))
  }

  test("empty row"){
    assert(!SearchSortedMatrix.searchMatrix(Array(Array()), 20))
  }
}
