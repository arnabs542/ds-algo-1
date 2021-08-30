package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class BSTNodesInRange {

    public int solve(TreeNode A, int B, int C) {
        return count(A, B, C);
    }

    private int count(TreeNode root, int B, int C) {

        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (root.val >= B && root.val <= C) {
            ans = 1 + count(root.left, B, C) + count(root.right, B, C);
        } else if (root.val > C) {
            ans += count(root.left, B, C);
        } else if (root.val < B) {
            ans += count(root.right, B, C);
        }
        return ans;
    }
}


