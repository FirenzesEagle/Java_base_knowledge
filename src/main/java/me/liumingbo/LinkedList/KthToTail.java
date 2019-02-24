package me.liumingbo.LinkedList;

public class KthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode ahead = head, behind = head;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next == null) {
                return null;
            } else {
                ahead = ahead.next;
            }
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}