package leetcode.primary.linkedlist

import leetcode.primary.linkedlist.MergeTwoLists.ListNode
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
    val list1 = makeLinkedList(arr1, len1)
    val len2 = arr2.length
    val list2 = makeLinkedList(arr2, len2)
    val newList = MergeTwoLists.mergeTwoLists(list1, list2)
    val newArr = linkedListToArray(newList, len1 + len2)
    println(s"merge ${arr1.toList} and ${arr2.toList}. \n\tresult = ${newArr.toList}")
    assert(newArr sameElements shouldBe)
  }

  private def makeLinkedList(nodes: Array[Int], len: Int): ListNode = {
    if (len == 0) {
      null
    } else {
      val nodeList = new Array[ListNode](len)
      nodeList(len - 1) = ListNode(nodes.last, null)
      for (i <- len - 2 to 0 by -1) {
        nodeList(i) = ListNode(nodes(i), nodeList(i + 1))
      }
      nodeList(0)
    }
  }

  private def linkedListToArray(newList: ListNode, len: Int): Array[Int] = {
    var cur = newList
    val result = new Array[Int](len)
    var i = 0
    while (cur != null) {
      result(i) = cur.x
      i += 1
      cur = cur.next
    }
    result
  }

}
