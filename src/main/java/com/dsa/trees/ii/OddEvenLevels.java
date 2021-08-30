package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class OddEvenLevels {

    private int oddSum = 0;
    private int evenSum = 0;

    public int solve(TreeNode A) {
        levelOrder(A); //do level order traversal
        return oddSum - evenSum;
    }

    private void levelOrder(TreeNode A) {

        if (A == null) {
            return;
        }

        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int size = 1;

        boolean reverse = false;
        while (!deque.isEmpty()) {

            TreeNode parent;

            if (reverse) {
                parent = deque.pollLast();
                evenSum += parent.val;
                if (parent.right != null) {
                    deque.addFirst(parent.right);
                }
                if (parent.left != null) {
                    deque.addFirst(parent.left);
                }
            } else {
                parent = deque.pollFirst();
                oddSum += parent.val;
                if (parent.left != null) {
                    deque.addLast(parent.left);
                }
                if (parent.right != null) {
                    deque.addLast(parent.right);
                }
            }

            if (--size == 0) {
                reverse = !reverse;
                size = deque.size();
            }
        }
    }
}


