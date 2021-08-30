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
