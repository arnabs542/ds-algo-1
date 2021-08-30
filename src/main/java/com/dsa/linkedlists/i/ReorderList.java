package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class ReorderList {

    public ListNode reorderList(ListNode A) {

        ListNode slow = A; //points to middle of the list
        ListNode fast = A;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the linked list from middle till last
        ListNode middle = slow.next;
        slow.next = null; //terminate part1 of LL
        ListNode reverseHead = reverseLL(middle); //head of part2 of LL

        mergeTwoListsAlternativeFashion(A, reverseHead);
        return A;
    }

    private void mergeTwoListsAlternativeFashion(ListNode head1, ListNode head2) {
        //merge the two LLs to result in alternative fashion
        while (head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;
            head2 = next2;
            head1 = next1;
        }
    }

    private ListNode reverseLL(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; //next node of curr
            curr.next = prev; //make LL point backwards
            prev = curr;
            curr = next;
        }
        return prev;//head of the reversed LL
    }
}
