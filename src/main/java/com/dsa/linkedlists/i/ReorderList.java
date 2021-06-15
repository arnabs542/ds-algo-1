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
/*
Reorder List
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [1, 2, 3, 4]


Example Output
Output 1:

 [1, 5, 2, 4, 3]
Output 2:

 [1, 4, 2, 3]


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].
 */