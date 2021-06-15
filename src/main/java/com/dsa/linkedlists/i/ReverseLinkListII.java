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
/*
Reverse Link List II
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation
Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1

 */