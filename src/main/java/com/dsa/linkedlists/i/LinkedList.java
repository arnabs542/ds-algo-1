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
