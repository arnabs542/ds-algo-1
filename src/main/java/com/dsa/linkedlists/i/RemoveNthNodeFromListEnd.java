package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode curr = A;
        ListNode prev = dummy;

        int count = 1;
        while (count < B) {
            curr = curr.next;
            count++;
        }

        ListNode pres = A;
        while (curr.next != null) {
            prev = pres;
            pres = pres.next;
            curr = curr.next;
        }
        prev.next = pres.next;
        return dummy.next;
    }
}


