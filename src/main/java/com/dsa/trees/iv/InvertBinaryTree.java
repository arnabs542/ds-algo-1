package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode A) {
        return mirror(A);
    }

    private TreeNode mirror(TreeNode root) {

        if (root == null) {
            return null;
        }
        //swap left and right subtrees
        TreeNode temp = root.right;
        root.right = mirror(root.left);
        root.left = mirror(temp);

        return root;
    }
}

/*
Invert the Binary Tree
Problem Description

Given a binary tree A, invert the binary tree and return it.

Inverting refers to making left child as the right child and vice versa.



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree A.



Output Format
Return the head of the inverted tree.



Example Input
Input 1:


     1
   /   \
  2     3
Input 2:


     1
   /   \
  2     3
 / \   / \
4   5 6   7


Example Output
Output 1:


     1
   /   \
  3     2
Output 2:


     1
   /   \
  3     2
 / \   / \
7   6 5   4


Example Explanation
Explanation 1:

Tree has been inverted.
Explanation 2:

Tree has been inverted

 */
