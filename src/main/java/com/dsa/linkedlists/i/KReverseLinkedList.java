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
/*
K reverse linked list
Problem Description

Given a singly linked list head and an integer k, reverse the nodes of the list k at a time and return modified linked list.



Problem Constraints
1 <= |head| <= 103

k always divides head



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, k.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 head = [1, 2, 3, 4, 5, 6]
 k = 2
Input 2:

 head = [1, 2, 3, 4, 5, 6]
 k = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]

 */