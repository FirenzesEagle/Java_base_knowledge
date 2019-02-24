package me.liumingbo.LinkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode ahead = head, behind = head;
        for (int i = 0; i < n; i++) {
            ahead = ahead.next;
        }
        if (ahead == null) {
            head = head.next;
            return head;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return head;
    }
}
