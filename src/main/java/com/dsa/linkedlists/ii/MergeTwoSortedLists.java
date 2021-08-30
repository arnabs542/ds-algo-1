package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (A != null && B != null) {
            if (A.val <= B.val) {
                curr.next = A;
                A = A.next;
            } else {
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }
        if (A == null) {
            curr.next = B;
        } else if (B == null) {
            curr.next = A;
        }
        return dummy.next;
    }
}

