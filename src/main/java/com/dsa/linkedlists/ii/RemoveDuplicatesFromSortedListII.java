package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode A) {

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prev = dummy;
        ListNode curr = A;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {
                int value = curr.val;
                while (curr != null && curr.val == value) {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}

