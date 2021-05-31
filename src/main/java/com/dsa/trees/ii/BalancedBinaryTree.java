package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class BalancedBinaryTree {

    public int isBalanced(TreeNode A) {

        Pair<Integer, Boolean> tree = maxHeightRootedAt(A);

        return tree.isBalanced ? 1 : 0;
    }

    private Pair<Integer, Boolean> maxHeightRootedAt(TreeNode root) {

        if (root == null) {// height of leaf is 0, so height of null node has to be one lesser
            return new Pair<>(-1, true);
        }

        Pair<Integer, Boolean> left = maxHeightRootedAt(root.left);
        int heightLeft = left.height; //find height of left sub-tree

        if (left.isBalanced) { //recurse right sub-tree only if left sub-tree is balanced

            Pair<Integer, Boolean> right = maxHeightRootedAt(root.right);
            int heightRight = right.height; //find height of right sub-tree

            if (right.isBalanced) {
                return new Pair<>(Math.max(heightLeft, heightRight) + 1, Math.abs(heightLeft - heightRight) <= 1);
            } else {
                return new Pair<>(-1, false); //we don't care about height since its not balanced
            }
        } else {
            return new Pair<>(-1, false); //we don't care about height since its not balanced
        }
    }

    static class Pair<T, U> {
        T height;
        U isBalanced;

        Pair(T x, U y) {
            this.height = x;
            this.isBalanced = y;
        }
    }
}

/*
Balanced Binary Tree
Problem Description

Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the root of the tree A.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

    1
   / \
  2   3
Input 2:


       1
      /
     2
    /
   3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.

 */
