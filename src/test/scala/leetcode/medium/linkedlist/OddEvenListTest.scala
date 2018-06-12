package leetcode.medium.linkedlist

import leetcode.common.ListNode
import org.scalatest.FunSuite

class OddEvenListTest extends FunSuite{

  test("1->2->3->4->5"){
    check(Array(1,2,3,4,5),Array(1,3,5,2,4))
  }

  test("2->1->3->5->6->4->7"){
    check(Array(2,1,3,5,6,4,7),Array(2,3,6,7,1,5,4))
  }

  test("2->1"){
    check(Array(2,1),Array(2,1))
  }

  test("2"){
    check(Array(2),Array(2))
  }

  def check(arr: Array[Int], shouldBe: Array[Int]): Unit = {
    val list = ListNode.fromArray(arr)
    val result = ListNode.toArray(OddEvenList.oddEvenList(list), arr.length)
    assert(result sameElements shouldBe)
  }
}
