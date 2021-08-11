package com.dsa.dp.vi;

import com.dsa.trees.common.TreeNode;

public class MaxSumPathBinaryTree {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode A) {
        recurse(A);
        return ans;
    }

    //returns maxSum path through the current node
    private int recurse(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMax = recurse(root.left);
        int rightMax = recurse(root.right);

        //update ans
        ans = Math.max(ans, Math.max(0, leftMax) + Math.max(0, rightMax) + root.val); //ignore if node is giving negative value

        //both left and right subtree can't be in the same path, so take either
        return root.val + Math.max(Math.max(0, leftMax), Math.max(0, rightMax));
    }
}
/*
Max Sum Path in Binary Tree
Problem Description

Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints
1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



Input Format
The first and the only argument contains a pointer to the root of T, A.



Output Format
Return an integer representing the maximum sum path.



Example Input
Input 1:


    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50


Example Output
Output 1:

 6
Output 2:

 40


Example Explanation
Explanation 1:

     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:

     The path with maximum sum is: 20 -> 20
 */
