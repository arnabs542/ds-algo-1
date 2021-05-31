package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class DiameterOfBinaryTree {

    private int ans = 0;

    public int solve(TreeNode A) {

        int maxHeight = maxHeightRootedAt(A);
        return ans;
    }

    private int maxHeightRootedAt(TreeNode root) {

        if (root == null) {// height of leaf is 0, so height of null node has to be one lesser
            return -1;
        }

        int heightLeft = maxHeightRootedAt(root.left); //find height of left sub-tree
        int heightRight = maxHeightRootedAt(root.right); //find height of right sub-tree

        ans = Math.max(ans, (heightRight + heightLeft + 2)); //length of longest path passing through curr node will be maxRight+maxLeft+2

        return Math.max(heightRight, heightLeft) + 1; //height of tree at curr node equals max(left,right) + 1
    }
}

/*
Diameter of binary tree
Problem Description

Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return an single integer denoting the diameter of the tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

 3
Output 2:

 4


Example Explanation
Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.

 */
