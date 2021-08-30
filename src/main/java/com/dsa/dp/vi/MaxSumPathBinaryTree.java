package com.dsa.dp.vi;

import com.dsa.trees.common.TreeNode;

public class MaxSumPathBinaryTree {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode A) {
        recurse(A);
        return ans;
    }

    //returns maxSum path through the current node
    private int recurse(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMax = recurse(root.left);
        int rightMax = recurse(root.right);

        //update ans
        ans = Math.max(ans, Math.max(0, leftMax) + Math.max(0, rightMax) + root.val); //ignore if node is giving negative value

        //both left and right subtree can't be in the same path, so take either
        return root.val + Math.max(Math.max(0, leftMax), Math.max(0, rightMax));
    }
}

