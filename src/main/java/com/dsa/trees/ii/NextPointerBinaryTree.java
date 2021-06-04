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

/*
Next Pointer Binary Tree
Problem Description

Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return the head of the binary tree after the changes are made.



Example Input
Input 1:


     1
    /  \
   2    3
Input 2:


        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Example Output
Output 1:


        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:


         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL


Example Explanation
Explanation 1:

Next pointers are set as given in the output.
Explanation 2:

Next pointers are set as given in the output.

 */
