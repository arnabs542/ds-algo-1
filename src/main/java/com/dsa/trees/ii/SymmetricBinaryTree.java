package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSym(A.left, A.right) ? 1 : 0;
    }

    //checks if left and right subtrees are identical
    private boolean isSym(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null && root1.val == root2.val) //if current node matches, check left and right subtrees
            return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);

        return false;
    }
}

/*
Symmetric Binary Tree
Problem Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is the root node of the binary tree.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ).



Example Input
Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The above binary tree is symmetric.
Explanation 2:

The above binary tree is not symmetric.
 */
