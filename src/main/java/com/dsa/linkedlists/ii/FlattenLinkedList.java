package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class FlattenLinkedList {
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode result;
        if (a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }

    private ListNode flatten(ListNode root) {
        if (root == null || root.next == null)
            return root;
        return merge(root, flatten(root.next));
    }
}

