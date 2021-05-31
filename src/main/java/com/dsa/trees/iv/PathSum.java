package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class PathSum {

    private boolean hasPathSum = false;
    private int sum = 0;

    public int hasPathSum(TreeNode A, int B) {
        recurse(A, 0, B);
        return hasPathSum ? 1 : 0;
    }

    private void recurse(TreeNode root, int currSum, int B) {

        if (hasPathSum || root == null) { //avoid unnecessary recursions further
            return;
        }

        if (root.left == null && root.right == null) { //means root is leaf node
            if (currSum + root.val == B) {
                hasPathSum = true;
            }
        }

        recurse(root.left, currSum + root.val, B); //add current val and go left
        recurse(root.right, currSum + root.val, B); //add current val and go right
    }
}

/*
Path Sum
Problem Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints
1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.



Output Format
Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.



Example Input
Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22
Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:

 There is no path which has sum -1
 */
