package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class KthSmallestElementInTree {

    public int kthsmallest(TreeNode A, int B) {

        Stack<TreeNode> stack = new Stack<>(); //store visited elements, to print them later   L n R
        TreeNode curr = A;

        //iterative inorder traversal
        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;  //keep going left
            } else {
                TreeNode temp = stack.pop(); //pop from stack and add to ans
                curr = temp.right; //go right

                if (--B == 0) { //we have found Bth smallest element
                    return temp.val;
                }
            }
        }
        return -1;
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
