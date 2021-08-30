package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

public class LargestBSTSubtree {

    private int ans = -1;

    public int solve(TreeNode A) {
        isBST(A);
        return ans;
    }

    private Pair<Boolean, Integer, Integer, Integer> isBST(TreeNode root) {

        if (root == null) {
            return new Pair<>(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Pair<Boolean, Integer, Integer, Integer> left = isBST(root.left);
        Pair<Boolean, Integer, Integer, Integer> right = isBST(root.right);

        if (left.isBst && left.max < root.val
                && right.isBst && right.min > root.val) { //if left subtree max less than current node
            ans = Math.max(ans, left.size + right.size + 1);
            return new Pair<>(true, Math.max(root.val, right.max), Math.min(root.val, left.min),
                    left.size + right.size + 1);
        }
        return new Pair<>(false, -1, -1, -1); //if not a bst, i dont care about min/max
    }

    // T -> isBst, U -> max of tree at node, V -> min of tree at node, Z -> size of tree at the node as root
    static class Pair<T, U, V, Z> {
        T isBst;
        U max;
        V min;
        Z size;

        Pair(T x, U y, V z, Z a) {
            this.isBst = x;
            this.max = y;
            this.min = z;
            this.size = a;
        }
    }
}


