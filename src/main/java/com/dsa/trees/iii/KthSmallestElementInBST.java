package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class KthSmallestElementInBST {

    private static int k;

    public int kthsmallest(TreeNode A, int B) {
        k = B;
        return recurse(A);
    }

    private int recurse(TreeNode curr) {
        if (curr == null) {
            return -1;
        }
        int left = recurse(curr.left);

        if (left != -1) {
            return left; //left has B or more elements
        }
        if (--k == 0) {
            return curr.val;
        }
        return recurse(curr.right); //left has less than B elements
    }
}


