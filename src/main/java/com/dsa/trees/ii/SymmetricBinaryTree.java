package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSym(A.left, A.right) ? 1 : 0;
    }

    //checks if left and right subtrees are identical
    private boolean isSym(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null && root1.val == root2.val) //if current node matches, check left and right subtrees
            return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);

        return false;
    }
}


