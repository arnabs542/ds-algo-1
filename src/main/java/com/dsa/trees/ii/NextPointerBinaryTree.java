package com.dsa.trees.ii;

import com.dsa.trees.common.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextPointerBinaryTree {

    public void connect(TreeLinkNode root) {

        TreeLinkNode A = root;
        levelOrder(A);
    }

    private void levelOrder(TreeLinkNode A) {

        if (A == null) {
            return;
        }
        TreeLinkNode root = A;

        Deque<TreeLinkNode> deque = new ArrayDeque<>(); //keep adding to queue
        deque.add(root);

        while (!deque.isEmpty()) {

            int n = deque.size();

            for (int i = 0; i < n; i++) {
                TreeLinkNode parent = deque.pollFirst();
                if (i == n - 1) {
                    parent.next = null;
                } else {
                    parent.next = deque.peekFirst();
                }
                //add left and right childs to queue
                if (parent.left != null) {
                    deque.addLast(parent.left);
                }
                if (parent.right != null) {
                    deque.addLast(parent.right);
                }
            }
        }
    }
}


