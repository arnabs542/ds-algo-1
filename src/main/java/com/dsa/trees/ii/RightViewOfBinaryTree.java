package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RightViewOfBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }

        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>(); //keep adding to queue
        deque.add(root);
        int size = 1;

        ArrayList<Integer> level = new ArrayList<>(); //all nodes of one level

        while (!deque.isEmpty()) {

            TreeNode parent = deque.pollFirst(); //for each pop, we are adding two more nodes to the queue

            //add left and right childs to queue
            if (parent.left != null) {
                deque.addLast(parent.left);
            }
            if (parent.right != null) {
                deque.addLast(parent.right);
            }
            level.add(parent.val); //add current node to level array list

            if (--size == 0) {
                ans.add(level.get(level.size() - 1)); //add the last one in the level to the ans, when size is 0
                level.clear(); //clear for reuse
                size = deque.size(); //reset size to queue size
            }
        }

        return ans;
    }
}

/*
Right view of Binary tree
Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



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

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.

 */
