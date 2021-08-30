package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

public class BalancedBinaryTree {

    public int isBalanced(TreeNode A) {

        Pair<Integer, Boolean> tree = maxHeightRootedAt(A);

        return tree.isBalanced ? 1 : 0;
    }

    private Pair<Integer, Boolean> maxHeightRootedAt(TreeNode root) {

        if (root == null) {// height of leaf is 0, so height of null node has to be one lesser
            return new Pair<>(-1, true);
        }

        Pair<Integer, Boolean> left = maxHeightRootedAt(root.left);
        int heightLeft = left.height; //find height of left sub-tree

        if (left.isBalanced) { //recurse right sub-tree only if left sub-tree is balanced

            Pair<Integer, Boolean> right = maxHeightRootedAt(root.right);
            int heightRight = right.height; //find height of right sub-tree

            if (right.isBalanced) {
                return new Pair<>(Math.max(heightLeft, heightRight) + 1, Math.abs(heightLeft - heightRight) <= 1);
            } else {
                return new Pair<>(-1, false); //we don't care about height since its not balanced
            }
        } else {
            return new Pair<>(-1, false); //we don't care about height since its not balanced
        }
    }

    static class Pair<T, U> {
        T height;
        U isBalanced;

        Pair(T x, U y) {
            this.height = x;
            this.isBalanced = y;
        }
    }
}


