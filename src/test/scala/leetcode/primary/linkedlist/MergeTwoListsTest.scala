package leetcode.primary.linkedlist

import org.scalatest.FunSuite

class MergeTwoListsTest extends FunSuite {

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
    val len1 = arr1.length
    val list1 = ListNode.makeLinkedList(arr1, len1)
    val len2 = arr2.length
    val list2 = ListNode.makeLinkedList(arr2, len2)
    val newList = MergeTwoLists.mergeTwoLists(list1, list2)
    val newArr = ListNode.linkedListToArray(newList, len1 + len2)
    println(s"merge ${arr1.toList} and ${arr2.toList}. \n\tresult = ${newArr.toList}")
    assert(newArr sameElements shouldBe)
  }
}
