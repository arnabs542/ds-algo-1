package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class MiddleElementLinkedList {
    public int solve(ListNode A) {

        ListNode slow = A; //points to middle of the list
        ListNode fast = A;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
