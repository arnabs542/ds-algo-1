package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class ValidBST {

    public int isValidBST(TreeNode A) {
        return isBST(A).isBst ? 1 : 0;
    }

    private Pair<Boolean, Integer, Integer> isBST(TreeNode root) {

        if (root == null) {
            return new Pair<>(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Pair<Boolean, Integer, Integer> left = isBST(root.left);

        if (left.max < root.val && left.isBst) { //if left subtree max less than current node

            Pair<Boolean, Integer, Integer> right = isBST(root.right);

            if (right.min > root.val && right.isBst) {//if right subtree min greater than current node
                return new Pair<>(true, Math.max(root.val, right.max), Math.min(root.val, left.min));
            }
        }
        return new Pair<>(false, -1, -1); //if not a bst, i dont care about min/max
    }

    static class Pair<T, U, V> {
        T isBst;
        U max;
        V min;

        Pair(T x, U y, V z) {
            this.isBst = x;
            this.max = y;
            this.min = z;
        }
    }
}


