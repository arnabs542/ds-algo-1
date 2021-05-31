package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class ValidBinarySearchTree {

    public int isValidBST(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = A;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                if (prev != null && prev.val >= temp.val) {
                    return 0;
                }
                prev = temp;
                cur = temp.right;
            }
        }
        return 1;
    }

    private Pair<Boolean, Integer, Integer> isBST(TreeNode root) {

        if (root == null) {
            return new Pair<>(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Pair<Boolean, Integer, Integer> left = isBST(root.left);

        if (left.max < root.val && left.isBst) { //if left subtree max less than current node

            Pair<Boolean, Integer, Integer> right = isBST(root.right);

            if (right.min > root.val && right.isBst) {//if right subtree min greater than current node
                return new Pair<>(true, Math.max(root.val, right.max), Math.min(root.val, left.min));
            }
        }
        return new Pair<>(false, -1, -1); //if not a bst, i dont care about min/max
    }

    // T -> isBst, U -> max of tree at node, V -> min of tree at node
    static class Pair<T, U, V> {
        T isBst;
        U max;
        V min;

        Pair(T x, U y, V z) {
            this.isBst = x;
            this.max = y;
            this.min = z;
        }
    }
}

/*
Valid Binary Search Tree
Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.

 */
