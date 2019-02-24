package me.liumingbo.LinkedList;

public class PlusLinkedList {
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode p = l1, q = l2, current = headNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return headNode.next;
    }
}