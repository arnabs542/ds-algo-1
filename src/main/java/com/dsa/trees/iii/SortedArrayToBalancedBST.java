package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class SortedArrayToBalancedBST {

    public TreeNode sortedArrayToBST(final int[] A) {

        if (A.length == 0) {
            return null;
        }
        return constructBST(0, A.length - 1, A);
    }

    //returns a node as root of a BST formed using elements in array from start to end
    private TreeNode constructBST(int start, int end, int[] A) {

        if (start > end) {
            return null;
        }

        int mid = start + ((end - start) / 2);

        TreeNode node = new TreeNode(A[mid]);
        node.left = constructBST(start, mid - 1, A); //attach left subtree
        node.right = constructBST(mid + 1, end, A); //attach right subtree

        return node;
    }
}


