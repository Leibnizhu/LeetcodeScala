package leetcode.primary.linkedlist

import leetcode.common.ListNode
import org.scalatest.funsuite.AnyFunSuite

class MergeTwoListsTest extends AnyFunSuite {

  test("1->2->4, 1->3->4") {
    check(Array(1, 2, 4), Array(1, 3, 4), Array(1, 1, 2, 3, 4, 4))
  }

  test("2,1") {
    check(Array(2), Array(1), Array(1, 2))
  }

  test("null,1") {
    check(Array(), Array(1), Array(1))
  }

  test("1, null") {
    check(Array(1), Array(), Array(1))
  }

  private def check(arr1: Array[Int], arr2: Array[Int], shouldBe: Array[Int]): Unit = {
    val list1 = ListNode.fromArray(arr1)
    val list2 = ListNode.fromArray(arr2)
    val newList = MergeTwoLists.mergeTwoLists(list1, list2)
    val newArr = ListNode.toArray(newList, arr1.length + arr2.length)
    println(s"merge ${arr1.toList} and ${arr2.toList}. \n\tresult = ${newArr.toList}")
    assert(newArr sameElements shouldBe)
  }
}
