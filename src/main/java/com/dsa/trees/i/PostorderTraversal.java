package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>(); //store visited nodes in stack, as we will need them later
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.right; //go right, as we want preorder of mirror-imaged tree
            } else {
                TreeNode temp = stack.pop();
                curr = temp.left;
            }
        }
        Collections.reverse(ans); //postorder = Reverse of (preorder of mirror-imaged tree)
        return ans;
    }
}

/*
Postorder Traversal
Problem Description

Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.



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

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */