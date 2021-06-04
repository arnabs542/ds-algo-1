package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class KthSmallestElementInBST {

    private static int k;

    public int kthsmallest(TreeNode A, int B) {
        k = B;
        return recurse(A);
    }

    private int recurse(TreeNode curr) {
        if (curr == null) {
            return -1;
        }
        int left = recurse(curr.left);

        if (left != -1) {
            return left; //left has B or more elements
        }
        if (--k == 0) {
            return curr.val;
        }
        return recurse(curr.right); //left has less than B elements
    }
}

/*
Kth Smallest Element In Tree
Problem Description

Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an integer, representing the Bth element.



Example Input
Input 1:


            2
          /   \
         1    3
B = 2
Input 2:


            3
           /
          2
         /
        1
B = 1



Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1.
 */
