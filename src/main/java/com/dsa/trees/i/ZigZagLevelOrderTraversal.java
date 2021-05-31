package com.dsa.trees.i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class ZigZagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        //same approach as level order traversal, just need to alternatively reverse while adding to ans
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }

        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int size = 1;

        ArrayList<Integer> level = new ArrayList<>();

        boolean reverse = false;
        while (!deque.isEmpty()) {

            TreeNode parent = deque.pollFirst();

            if (parent.left != null) {
                deque.addLast(parent.left);
            }
            if (parent.right != null) {
                deque.addLast(parent.right);
            }
            level.add(parent.val);

            if (--size == 0) {
                ArrayList<Integer> temp = new ArrayList<>(level);

                if (reverse) {
                    Collections.reverse(temp);
                    reverse = false;
                } else {
                    reverse = true;
                }
                ans.add(temp);
                level.clear();
                size = deque.size();
            }
        }

        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

/*
ZigZag Level Order Traversal BT
Problem Description

Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [2, 6]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the zigzag traversal of each level.
 */