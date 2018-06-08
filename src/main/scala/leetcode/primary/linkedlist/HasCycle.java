package leetcode.primary.linkedlist;

import leetcode.primary.linkedlist.DeleteNode.ListNode;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 *
 * 给定一个链表，判断链表中是否有环。
 * 进阶：你能否不使用额外空间解决此题？
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
//        System.out.println(fast == null ? "null" : fast.x+","+slow.x);
        return fast == slow;
    }
}
