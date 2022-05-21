package leetcode.daily

import org.scalatest.FunSuite

class DeleteColumnsToMakeSortedTest extends FunSuite {
  test("cba,daf,ghi") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("cba", "daf", "ghi")) == 1)
  }

  test("a,b") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("a", "b")) == 0)
  }

  test("b,a") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("b", "a")) == 1)
  }

  test("empty str") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("", "")) == 0)
  }

  test("empty array") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array()) == 0)
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("")) == 0)
  }

  test("zyx,wvu,tsr") {
    assert(DeleteColumnsToMakeSorted.minDeletionSize(Array("zyx", "wvu", "tsr")) == 3)
  }

}