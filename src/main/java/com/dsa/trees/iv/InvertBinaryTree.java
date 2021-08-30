package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode A) {
        return mirror(A);
    }

    private TreeNode mirror(TreeNode root) {

        if (root == null) {
            return null;
        }
        //swap left and right subtrees
        TreeNode temp = root.right;
        root.right = mirror(root.left);
        root.left = mirror(temp);

        return root;
    }
}


