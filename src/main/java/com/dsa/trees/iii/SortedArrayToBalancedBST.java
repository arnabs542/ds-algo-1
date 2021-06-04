package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class SortedArrayToBalancedBST {

    public TreeNode sortedArrayToBST(final int[] A) {

        if (A.length == 0) {
            return null;
        }
        return constructBST(0, A.length - 1, A);
    }

    //returns a node as root of a BST formed using elements in array from start to end
    private TreeNode constructBST(int start, int end, int[] A) {

        if (start > end) {
            return null;
        }

        int mid = start + ((end - start) / 2);

        TreeNode node = new TreeNode(A[mid]);
        node.left = constructBST(start, mid - 1, A); //attach left subtree
        node.right = constructBST(mid + 1, end, A); //attach right subtree

        return node;
    }
}

/*
Sorted Array To Balanced BST
Problem Description

Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000



Input Format
First argument is an integer array A.



Output Format
Return a root node of the Binary Search Tree.



Example Input
Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output
Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.
 */
