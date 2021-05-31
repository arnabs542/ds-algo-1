package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class OddEvenLevels {

    public int solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = levelOrder(A); //do level order traversal

        int oddSum = 0;
        int evenSum = 0;

        //add to appropriate sum alternatively
        for (int i = 0; i < ans.size(); i++) {

            int sum = ans.get(i).stream().mapToInt(Integer::intValue).sum();

            if (i % 2 == 0) {
                oddSum += sum;
            } else {
                evenSum += sum;
            }
        }

        return oddSum - evenSum;
    }

    private ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

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
