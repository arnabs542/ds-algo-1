package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class DistanceBetweenNodesOfBST {
    public int solve(TreeNode A, int B, int C) {

        TreeNode lca = lca(A, B, C);
        return depthOfNode(lca, B) + depthOfNode(lca, C);
    }

    //returns the depth of a node having val 'num' from 'root'
    private int depthOfNode(TreeNode root, int num) {

        int depth = 0;
        TreeNode ptr = root;

        while (ptr != null) {
            if (ptr.val > num) {
                ptr = ptr.left;
            } else if (ptr.val < num) {
                ptr = ptr.right;
            } else break;
            depth++;
        }
        return depth;
    }

    //returns the node that is LCA of B and C
    private TreeNode lca(TreeNode root, int B, int C) {

        TreeNode ptr = root;

        while (ptr != null) {
            if (ptr.val > B && ptr.val > C) {
                ptr = ptr.left;
            } else if (ptr.val < B && ptr.val < C) {
                ptr = ptr.right;
            } else return ptr;
        }
        return null;
    }
}


