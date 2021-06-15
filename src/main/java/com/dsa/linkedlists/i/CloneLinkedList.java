package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class CloneLinkedList {
    ListNode cloneList(ListNode A) {

        ListNode ptr = A;
        //append cloned nodes next to original nodes
        while (ptr != null) {

            ListNode newNode = new ListNode(ptr.val);

            ListNode nextNode = ptr.next;
            ptr.next = newNode;
            newNode.next = nextNode;

            ptr = nextNode;
        }
        ptr = A;
        //update random pointers of new nodes
        while (ptr != null && ptr.next != null) {

            if (ptr.random == null) {
                ptr.next.random = null;
            } else {
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }
        ListNode newHead = A.next;

        ListNode ptr1 = A; //pointer to original nodes
        ListNode ptr2 = A.next; //pointer to cloned nodes

        // detach the original nodes
        while (ptr1 != null && ptr1.next != null) {

            ptr1.next = ptr2.next;

            if (ptr1.next != null) {
                ptr2.next = ptr1.next.next;
            } else {
                ptr2.next = null;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return newHead;
    }
}
/*

Clone a Linked List
Problem Description

Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.

You have to create a copy of this list and return the head pointer of the duplicated list.



Problem Constraints
1 <= length of the list <= 100000

1 <= Value of node <= 100000



Input Format
The only argument given is head pointer of the doubly linked list.



Output Format
Return the head pointer of the duplicated list.



Example Input
Input 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Input 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Output
Output 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Output 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Explanation
Explanation 1:

 Just clone the given list.
Explanation 2:

 Just clone the given list

 */