package me.liumingbo.LinkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode currentNext = null;
        ListNode current = head.next;
        while (current != null) {
            currentNext = current.next;
            current.next = head;
            head = current;
            current = currentNext;
        }
        return head;
    }
}