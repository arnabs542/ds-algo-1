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

/*
Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
 */