package leetcode.medium.linkedlist

import leetcode.common.ListNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/83/
  *
  *  给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
  * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
  * 说明:
  *  - 应当保持奇数节点和偶数节点的相对顺序。
  *  - 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
  */
object OddEvenList {
  /**
    * 一个总游标记录在原链上行走的进度
    * 再增加两个奇偶游标,记录在新的奇偶链上的进度
    * 通过总游标进行遍历,遍历到奇数或偶数次序时,分别使用奇偶游标增加奇偶链的节点
    * 要注意清理总游标原来的next,防止形成环路
    */
  def oddEvenList(head: ListNode): ListNode = {
    val oddHead = ListNode(-1) //奇链表头的前一位
    val evenHead = ListNode(-1) //偶链表头的前一位
    var pOdd = oddHead// 奇链表游标
    var pEven = evenHead// 偶链表游标
    var p = head
    var index = 1
    while(p !=null){
      if(index % 2 == 1){ //奇数节点
        pOdd.next = p
        pOdd = pOdd.next
      } else {
        pEven.next = p
        pEven = pEven.next
      }
      index+=1
      //清理掉原来的链表关系,防止构成环路
      val tmp = p.next
      p.next = null
      p = tmp
    }
    pOdd.next = evenHead.next
    oddHead.next
  }
}
