package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {

        if (B == C) { //no need to reverse anything
            return A;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prev = dummy;
        ListNode curr = A;
        int count = 1;
        while (count < B) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        //curr points to node from where reversal has to happen
        //prev = prev elem of curr
        ListNode join = prev; //join needs to point to head of reversedList
        ListNode tail = curr; //curr will be tail of the reversedList

        while (count <= C) {
            ListNode next = curr.next; //next node of curr
            curr.next = prev; //make LL point backwards
            prev = curr;
            curr = next;

            count++;
        }
        join.next = prev; //connect beginning part of originalList with reversedList
        tail.next = curr; //connect tail of the reversedList to the originalList
        return dummy.next;
    }
}
