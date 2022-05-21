package leetcode.medium.linkedlist

import leetcode.primary.linkedlist.DeleteNode.ListNode
import org.scalatest.funsuite.AnyFunSuite

class IntersectionNodeTest extends AnyFunSuite {
  /**
    * 下面的两个链表：
    *
    * A:      a1 → a2
    *                 ↘
    *                   c1 → c2 → c3
    *                 ↗
    * B: b1 → b2 → b3
    * 在节点 c1 开始相交。
    */
    test("leetcode sample"){
      val c3 = new ListNode(3,null)
      val c2 = new ListNode(2,c3)
      val c1 = new ListNode(1,c2)
      val a2 = new ListNode(2,c1)
      val a1 = new ListNode(1,a2)
      val b3 = new ListNode(3,c1)
      val b2 = new ListNode(2,b3)
      val b1 = new ListNode(1,b2)
      val result1 = new IntersectionNode().getIntersectionNode(a1,b1)
      assert(result1 == c1)
      val result2 = new IntersectionNode().getIntersectionNode(b1,a1)
      assert(result2 == c1)
    }

  test("no intersection"){
    val a2 = new ListNode(2,null)
    val a1 = new ListNode(1,a2)
    val b3 = new ListNode(3,null)
    val b2 = new ListNode(2,b3)
    val b1 = new ListNode(1,b2)
    val result1 = new IntersectionNode().getIntersectionNode(a1,b1)
    assert(result1 == null)
    val result2 = new IntersectionNode().getIntersectionNode(b1,a1)
    assert(result2 == null)
  }

  test("A = null"){
    val b3 = new ListNode(3,null)
    val b2 = new ListNode(2,b3)
    val b1 = new ListNode(1,b2)
    val result1 = new IntersectionNode().getIntersectionNode(null,b1)
    assert(result1 == null)
    val result2 = new IntersectionNode().getIntersectionNode(b1,null)
    assert(result2 == null)
  }

  test("B = null"){
    val a2 = new ListNode(2,null)
    val a1 = new ListNode(1,a2)
    val result1 = new IntersectionNode().getIntersectionNode(a1,null)
    assert(result1 == null)
    val result2 = new IntersectionNode().getIntersectionNode(null,a1)
    assert(result2 == null)
  }

  test("null and null"){
    assert(new IntersectionNode().getIntersectionNode(null,null) == null)
  }
}