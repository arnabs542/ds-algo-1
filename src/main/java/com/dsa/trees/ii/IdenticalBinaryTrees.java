package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode A, TreeNode B) {
        return isSame(A, B) ? 1 : 0;
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null && root1.val == root2.val) //if current node matches, check left and right subtrees
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);

        return false;
    }
}


