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


