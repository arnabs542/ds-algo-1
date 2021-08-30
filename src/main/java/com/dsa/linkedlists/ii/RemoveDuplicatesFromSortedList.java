package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head;
    }
}

