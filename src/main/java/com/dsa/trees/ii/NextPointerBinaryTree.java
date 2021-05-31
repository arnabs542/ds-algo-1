package com.dsa.trees.ii;

import com.dsa.trees.common.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
        int size = 1;

        ArrayList<TreeLinkNode> level = new ArrayList<>(); //all nodes of one level

        while (!deque.isEmpty()) {

            TreeLinkNode parent = deque.pollFirst(); //for each pop, we are adding two more nodes to the queue

            //add left and right childs to queue
            if (parent.left != null) {
                deque.addLast(parent.left);
            }
            if (parent.right != null) {
                deque.addLast(parent.right);
            }
            level.add(parent); //add current node to level array list

            if (--size == 0) {
                updatePointersInLevel(level); //update next pointers in curr level
                level.clear(); //clear for reuse
                size = deque.size(); //reset size to queue size
            }
        }
    }

    private void updatePointersInLevel(ArrayList<TreeLinkNode> level) {

        TreeLinkNode prev = level.get(0); //first node in the level

        int i = 1;
        while (i < level.size()) {
            TreeLinkNode next = level.get(i++); //next node in the level
            prev.next = next; //point prev node to next node
            prev = next; //update prev to next
        }
        prev.next = null; //point last node in the level to null
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
