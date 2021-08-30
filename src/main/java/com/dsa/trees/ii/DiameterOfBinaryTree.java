package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class DiameterOfBinaryTree {

    private int ans = 0;

    public int solve(TreeNode A) {

        int maxHeight = maxHeightRootedAt(A);
        return ans;
    }

    private int maxHeightRootedAt(TreeNode root) {

        if (root == null) {// height of leaf is 0, so height of null node has to be one lesser
            return -1;
        }

        int heightLeft = maxHeightRootedAt(root.left); //find height of left sub-tree
        int heightRight = maxHeightRootedAt(root.right); //find height of right sub-tree

        ans = Math.max(ans, (heightRight + heightLeft + 2)); //length of longest path passing through curr node will be maxRight+maxLeft+2

        return Math.max(heightRight, heightLeft) + 1; //height of tree at curr node equals max(left,right) + 1
    }
}


