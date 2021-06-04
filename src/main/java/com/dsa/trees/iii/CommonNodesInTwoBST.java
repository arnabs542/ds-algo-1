package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class CommonNodesInTwoBST {

    private Stack<TreeNode> firstBST = new Stack<>();
    private Stack<TreeNode> secondBST = new Stack<>();

    public int solve(TreeNode A, TreeNode B) {

        int mod = 1000000007;
        long ans = 0L;

        //good idea similar to two pointer approach, works because BST
        addToStack(A, true);
        addToStack(B, false);

        while (!firstBST.empty() && !secondBST.empty()) {
            TreeNode node1 = firstBST.peek();
            TreeNode node2 = secondBST.peek();

            if (node1.val == node2.val) {
                ans = (ans + node1.val) % mod;
                node1 = firstBST.pop();
                node2 = secondBST.pop();
                addToStack(node1.right, true);
                addToStack(node2.right, false);
            } else if (node1.val < node2.val) {
                node1 = firstBST.pop();
                addToStack(node1.right, true);
            } else {
                node1 = secondBST.pop();
                addToStack(node1.right, false);
            }
        }
        return (int) ans;
    }

    private void addToStack(TreeNode root, boolean toFirstBST) {
        if (toFirstBST) {
            while (root != null) {
                firstBST.push(root);
                root = root.left;
            }
        } else {
            while (root != null) {
                secondBST.push(root);
                root = root.left;
            }
        }
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
