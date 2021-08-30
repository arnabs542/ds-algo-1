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
