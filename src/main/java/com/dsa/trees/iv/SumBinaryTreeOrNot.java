package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class SumBinaryTreeOrNot {
    private boolean isSumTree = true;

    public int solve(TreeNode A) {
        sumTree(A);
        return isSumTree ? 1 : 0;
    }

    private int sumTree(TreeNode root) {

        if (!isSumTree) { //to avoid unnecessry recursions
            return -1;
        }
        if (root == null) { //sum of empty tree is 0 (as per question)
            return 0;
        }

        int lSum = sumTree(root.left); //sum of left subtree
        int rSum = sumTree(root.right); //sum of right subtree

        if (!(lSum == 0 && rSum == 0)) { //only if non-leaf node
            if (lSum + rSum != root.val) { //not a sumBinaryTree at this node
                isSumTree = false;
            }
        }
        return lSum + rSum + root.val;
    }
}


