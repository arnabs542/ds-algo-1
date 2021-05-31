package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();  //use stack to store visited nodes  n L R
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                ans.add(curr.val);
                stack.push(curr); //save to stack as we need to go right later
                curr = curr.left; //go left
            } else {
                TreeNode temp = stack.pop(); //pop and go right
                curr = temp.right;
            }
        }
        return ans;
    }
}

/*
Preorder Traversal
Problem Description

Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the preorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */