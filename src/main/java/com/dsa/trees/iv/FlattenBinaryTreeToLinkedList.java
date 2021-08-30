package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode a) {
        recurse(a);
        return a;
    }

    private Pair<TreeNode, TreeNode> recurse(TreeNode curr) {

        if (curr == null) {
            return new Pair<>(null, null);
        }

        Pair<TreeNode, TreeNode> lt = recurse(curr.left);
        Pair<TreeNode, TreeNode> rt = recurse(curr.right);

        curr.left = null;

        if (lt.head == null && rt.head == null) {
            return new Pair<>(curr, curr); //when left and right both null, head and tail will be curr itself
        } else if (lt.head == null) {
            curr.right = rt.head;
            return new Pair<>(curr, rt.tail); //when left is null and right non-null, head will be curr
        } else if (rt.head == null) {
            curr.right = lt.head;
            return new Pair<>(curr, lt.tail); //when left is non-null and right null
        } else {
            TreeNode temp = curr.right;
            curr.right = lt.head;
            lt.tail.right = temp;
            return new Pair<>(curr, rt.tail); //when both non-null
        }
    }

    //holds the head and tail of the list formed from a subtree
    static class Pair<T, U> {
        T head;
        U tail;

        Pair(T head, U tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}


