package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class BSTNodesInRange {

    public int solve(TreeNode A, int B, int C) {
        return count(A, B, C);
    }

    private int count(TreeNode root, int B, int C) {

        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (root.val >= B && root.val <= C) {
            ans = 1 + count(root.left, B, C) + count(root.right, B, C);
        } else if (root.val > C) {
            ans += count(root.left, B, C);
        } else if (root.val < B) {
            ans += count(root.right, B, C);
        }
        return ans;
    }
}

/*
BST nodes in a range
Problem Description

Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lies in the given range.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= B < = C <= 109



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.



Output Format
Return the count of the number of nodes that lies in the given range.



Example Input
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20
Input 2:

            8
           / \
          6  21
         / \
        1   4

     B = 2
     C = 20


Example Output
Output 1:

 5
Output 2:

 3


Example Explanation
Explanation 1:

 Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2:

 Nodes which are in range [2, 20] are : [8, 6, 4]
 */
