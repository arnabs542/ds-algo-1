package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.HashSet;
import java.util.Stack;

public class CommonNodesInTwoBST {

    public int solve(TreeNode A, TreeNode B) {

        int mod = 1000000007;

        HashSet<Integer> setA = new HashSet<>();

        //iterative inorder traversal of tree A
        Stack<TreeNode> stack = new Stack<>(); //store visited elements, to print them later   L n R
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;  //keep going left
            } else {
                TreeNode temp = stack.pop(); //pop from stack and add to ans
                setA.add(temp.val);
                curr = temp.right; //go right
            }
        }

        long ans = 0L;
        //iterative inorder traversal of tree B
        stack = new Stack<>(); //store visited elements, to print them later   L n R
        curr = B;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;  //keep going left
            } else {
                TreeNode temp = stack.pop(); //pop from stack and add to ans
                if (setA.contains(temp.val)) {
                    ans = (ans + temp.val) % mod;
                }
                curr = temp.right; //go right
            }
        }
        return (int) ans;
    }
}

/*
Common Nodes in Two BST
Problem Description

Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .

In case there is no common node, return 0.

NOTE:

Try to do it one pass through the trees.



Problem Constraints
1 <= Number of nodes in the tree A and B <= 105

1 <= Node values <= 106



Input Format
First argument represents the root of BST A.

Second argument represents the root of BST B.



Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .



Example Input
Input 1:

 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Input 2:

  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11


Example Output
Output 1:

 17
Output 2:

 46


Example Explanation
Explanation 1:

 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:

 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
 */
