package leetcode.medium.linkedlist;

import leetcode.primary.linkedlist.DeleteNode.ListNode;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/84/
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 这题又只能选java
 * 注意：
 * - 如果两个链表没有交点，返回 null.
 * - 在返回结果后，两个链表仍须保持原有的结构。
 * - 可假定整个链表结构中没有循环。
 * - 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode {
    /**
     * 如果只是为了判断是否相交,可以将B的尾部的next指向A头部,判断是否有环路,判断完要回复B的尾部,满足保持原有结构的要求.
     * 但是这里还要知道相交的起始节点,所以要:
     * 1.分别遍历两个链表,记录长度l1,l2和最后一个节点,时间O(n)空间O(1)
     * 2.判断两个尾部是否相等,不相等则没有交点返回null,相等则有交点
     * 3.长度较长的一个表先走abs(l1-l2),然后两个表一起走,
     * 4.每走一步判断是否两边节点相等,相等则相交,返回第一个相等的节点,时间O(n)空间O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        //1.分别遍历两个链表,记录长度l1,l2和最后一个节点,时间O(n)空间O(1)
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) { //用没有next作为终结条件,因为还有用队尾进行判断
            lenA++;
            pA = pA.next;
        }
        while (pB.next != null) {
            lenB++;
            pB = pB.next;
        }
        //2.判断两个尾部是否相等,不相等则没有交点返回null,相等则有交点
        if (pA != pB) {
            return null;
        }
        //3.长度较长的一个表先走abs(l1-l2),然后两个表一起走,
        int firstSteps = Math.abs(lenA - lenB);//要先走的步数
        ListNode firstP = lenA > lenB ? headA : headB;//长的先走
        while (firstSteps > 0) {
            firstP = firstP.next;
            firstSteps--;
        }
        if (lenA > lenB){
            pA = firstP;
            pB = headB;
        }
        else{
            pA = headA;
            pB = firstP;
        }
        //4.每走一步判断是否两边节点相等,相等则相交,返回第一个相等的节点,时间O(n)空间O(1)
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
