package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

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
                ans.add(new ArrayList<>(level)); //add to the ans, when size is 0
                level.clear(); //clear for reuse
                size = deque.size(); //reset size to queue size
            }
        }
        return ans;
    }
}

/*
Level Order
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



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
   [9, 20],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 */