package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode head, int k) {

        ListNode p = head;

        int count = 0;
        while (count < k && p != null) {
            p = p.next;
            count++;
        }
        //p points to next group's first node

        if (count == k) {
            ListNode reverseHead = reverseLL(head, k); //reverse first k nodes in LL
            head.next = reverseList(p, k); //recurse for next k group, and make head point to head of this
            return reverseHead; //return reverseHead
        }
        return head; //nothing to reverse, just return original
    }

    //reverse only first k nodes
    private ListNode reverseLL(ListNode head, int k) {

        ListNode prev = null;
        ListNode curr = head;

        int count = 0;
        while (count < k && curr != null) {
            ListNode next = curr.next; //next node of curr
            curr.next = prev; //make LL point backwards
            prev = curr;
            curr = next;

            count++;
        }
        return prev;//head of the reversed LL
    }
}
