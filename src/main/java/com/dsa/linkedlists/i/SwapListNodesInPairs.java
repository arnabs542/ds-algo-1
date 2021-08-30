package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prev = dummy;
        ListNode curr = A;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next; //next node to curr
            ListNode next1 = next.next; //node two places after curr

            curr.next = next1; //make curr point to the node two places after
            next.next = curr; //make next of curr point to curr

            prev.next = next; //attach prev to new head after swap
            prev = curr;
            curr = next1;
        }
        return dummy.next;
    }
}
