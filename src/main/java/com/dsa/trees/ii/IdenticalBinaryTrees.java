package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode A, TreeNode B) {
        return isSame(A, B) ? 1 : 0;
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null && root1.val == root2.val) //if current node matches, check left and right subtrees
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);

        return false;
    }
}

/*
Identical Binary Trees
Problem Description

Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is a root node of first tree, A.

Second argument is a root node of second tree, B.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Value of left child of the tree is different.
 */
