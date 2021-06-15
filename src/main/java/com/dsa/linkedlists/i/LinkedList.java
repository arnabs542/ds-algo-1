package com.dsa.linkedlists.i;

import com.dsa.linkedlists.ListNode;

public class LinkedList {
    private static ListNode head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (head == null) {// LL doeesn't exist yet, so create it
            head = new ListNode(value);
            return;
        }
        ListNode newNode = new ListNode(value);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 2;
            ListNode h = head;
            while (count < position && h != null) {
                h = h.next;
                count++;
            }
            ListNode next = h.next;
            h.next = newNode;
            newNode.next = next;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (position == 1) {
            head = head.next;
        } else {
            int count = 2;
            ListNode h = head;
            while (count < position && h != null) {
                h = h.next;
                count++;
            }
            if (h == null) { //nothing to delete
                return;
            }
            ListNode prev = h;
            ListNode toDelete = h.next;

            if (toDelete != null) {
                prev.next = toDelete.next;
            } else {
                prev.next = null; //case of last node being deleted
            }
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode h = head;
        while (h != null) {
            if (h.next == null) {
                System.out.print(h.val);
            } else {
                System.out.print(h.val + " ");
            }
            h = h.next;
        }
    }
}
/*
Linked-List
Problem Description

Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in new line.


Problem Constraints
1 <= position <= n where, n is the size of the linked-list.



Input Format
First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.


Output Format
When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
NOTE: You don't need to return anything.


Example Input
5
i 1 23
i 2 24
p
d 1
p


Example Output
23 24
24


Example Explanation
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.

 */