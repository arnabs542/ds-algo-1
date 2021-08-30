package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class BinaryTreeToCircularDoublyLinkedList {

    public TreeNode solve(TreeNode root) {
        Pair<TreeNode, TreeNode> ans = recurse(root);
        return ans.head;
    }

    private Pair<TreeNode, TreeNode> recurse(TreeNode curr) {

        if (curr == null) {
            return new Pair<>(null, null);
        }

        Pair<TreeNode, TreeNode> lt = recurse(curr.left);
        Pair<TreeNode, TreeNode> rt = recurse(curr.right);

        if (lt.head == null && rt.head == null) {
            return new Pair<>(curr, curr); //when left and right both null, head and tail will be curr itself
        } else if (lt.head == null) {
            curr.right = rt.head;
            rt.head.left = curr;
            return new Pair<>(curr, rt.tail); //when left is null and right non-null, head will be curr
        } else if (rt.head == null) {
            lt.tail.right = curr;
            curr.left = lt.tail;
            return new Pair<>(lt.head, curr); //when left is non-null and right null
        } else {
            lt.tail.right = curr;
            curr.left = lt.tail;

            curr.right = rt.head;
            rt.head.left = curr;
            return new Pair<>(lt.head, rt.tail); //when both non-null
        }
    }

    static class Pair<T, U> {
        T head;
        U tail;

        Pair(T head, U tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}


