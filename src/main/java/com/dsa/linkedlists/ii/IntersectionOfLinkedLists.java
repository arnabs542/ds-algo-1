package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        ListNode pA = a;
        ListNode pB = b;
        while (pA != pB) {
            pA = (pA == null) ? b : pA.next;
            pB = (pB == null) ? a : pB.next;
        }
        return pA;
    }
}
