package com.dsa.heaps.ii;

import com.dsa.linkedlists.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        Comparator<ListNode> customComparator = Comparator.comparing(p -> Integer.valueOf(p.val));

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(customComparator);
        //form minHeap with first elements of all sorted lists, store the reference to the head of the lists
        for (int i = 0; i < a.size(); i++) {
            minHeap.add(a.get(i));
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        //keep going till heap is empty
        while (minHeap.size() > 0) {
            ListNode currMin = minHeap.poll(); //heap's root will have the elem with least value

            if (currMin.next != null) { //check if the linked list still has more elements
                minHeap.add(currMin.next);
            }
            head.next = currMin;
            head = head.next;
        }
        return dummy.next;
    }
}
/*
Merge K Sorted Lists
Problem Description

Given a list containing head pointers of N sorted linked lists. Merge these N given sorted linked lists and return it as one sorted list.



Problem Constraints
1 <= total number of elements in given linked lists <= 100000



Input Format
First and only argument is a list containing N head pointers.



Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.



Example Input
Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:

 10 -> 12
 13
 5 -> 6


Example Output
Output 1:

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:

 5 -> 6 -> 10 -> 12 ->13


Example Explanation
Explanation 1:

 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:

 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

 */