package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class EqualTreePartition {

    private boolean isPossible = false;

    public int solve(TreeNode A) {

        int total = totalSum(A);
        if (total % 2 != 0) {
            return 0;
        }
        subTreeSum(A, A, total / 2);
        return isPossible ? 1 : 0;
    }

    private int subTreeSum(TreeNode root, TreeNode curr, int sum) {

        if (isPossible) { //no need to recurse, as we found already that its possible
            return -1;
        }
        if (curr == null) {
            return 0;
        }
        int lt = subTreeSum(root, curr.left, sum);
        int rt = subTreeSum(root, curr.right, sum);

        int currTotal = lt + rt + curr.val;

        // when total sum of tree is 0, then toAchieve is also 0, need to check for other subtrees with sum 0, so put curr != root
        if (currTotal == sum && curr != root) {
            isPossible = true;
        }
        return currTotal;
    }

    private int totalSum(TreeNode root) {

        int sum = 0;

        //preorder traversal to sum all nodes
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                sum += curr.val;
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                curr = temp.right;
            }
        }
        return sum;
    }
}

/*
Equal Tree Partition
Problem Description

Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

-109 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:


                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:


                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7:
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.

 */
