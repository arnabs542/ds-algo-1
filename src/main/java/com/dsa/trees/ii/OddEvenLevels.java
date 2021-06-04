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

/*
Odd and Even Levels
Problem Description

Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format
First and only argument is a root node of the binary tree, A



Output Format
Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.



Example Input
Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8
Input 2:

        1
       / \
      2   10
       \
        4


Example Output
Output 1:

 10
Output 2:

 -7


Example Explanation
Explanation 1:

 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
Explanation 2:

 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12

 */
