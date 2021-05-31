package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class LargestBSTSubtree {

    private int ans = -1;

    public int solve(TreeNode A) {
        isBST(A);
        return ans;
    }

    private Pair<Boolean, Integer, Integer, Integer> isBST(TreeNode root) {

        if (root == null) {
            return new Pair<>(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Pair<Boolean, Integer, Integer, Integer> left = isBST(root.left);

        if (left.isBst && left.max < root.val) { //if left subtree max less than current node

            Pair<Boolean, Integer, Integer, Integer> right = isBST(root.right);

            if (right.isBst && right.min > root.val) {//if right subtree min greater than current node
                ans = Math.max(ans, left.size + right.size + 1);
                return new Pair<>(true, Math.max(root.val, right.max), Math.min(root.val, left.min), left.size + right.size + 1);
            }
        }
        return new Pair<>(false, -1, -1, -1); //if not a bst, i dont care about min/max
    }

    // T -> isBst, U -> max of tree at node, V -> min of tree at node, Z -> size of tree at the node as root
    static class Pair<T, U, V, Z> {
        T isBst;
        U max;
        V min;
        Z size;

        Pair(T x, U y, V z, Z a) {
            this.isBst = x;
            this.max = y;
            this.min = z;
            this.size = a;
        }
    }
}

/*
Largest BST Subtree
Problem Description

Given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of whole tree.

NOTE:

Largest subtree means subtree with most number of nodes.


Problem Constraints
1 <= N <= 105



Input Format
First and only argument is an pointer to root of the binary tree A.



Output Format
Return an single integer denoting the size of the largest subtree which is also a BST.



Example Input
Input 1:

     10
    / \
   5  15
  / \   \
 1   8   7
Input 2:

     5
    / \
   3   8
  / \ / \
 1  4 7  9


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:

 Given binary tree itself is BST.

 */
