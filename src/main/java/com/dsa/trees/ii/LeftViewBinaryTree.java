package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LeftViewBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }
        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>(); //keep adding to queue
        deque.add(root);
        int size = 1;

        while (!deque.isEmpty()) {

            TreeNode parent = deque.pollFirst(); //for each pop, we are adding two more nodes to the queue

            //add left and right childs to queue
            if (parent.right != null) {
                deque.addLast(parent.right);
            }
            if (parent.left != null) {
                deque.addLast(parent.left);
            }
            if (--size == 0) {
                ans.add(parent.val); //add the leftmost to the ans, when size is 0
                size = deque.size(); //reset size to queue size
            }
        }
        return ans;
    }
}

/*
Left view of binary tree
Problem Description

Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format
First and only argument is a root node of the binary tree, A.



Output Format
Return an integer array denoting the left view of the Binary tree.



Example Input
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8]
Output 2:

 [1, 2, 4, 5]


Example Explanation
Explanation 1:

 The Left view of the binary tree is returned.

 */
