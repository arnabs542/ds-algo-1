package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

import java.util.HashMap;

public class LeastCommonAncestor {

    private int time = 0;
    private HashMap<Integer, Integer> in = new HashMap<>(); //stores in time of every node
    private HashMap<Integer, Integer> out = new HashMap<>(); //stores out time of every node

    public int lca(TreeNode A, int B, int C) {
        eulerTour(A);
        if (!(in.containsKey(B) && in.containsKey(C))) { //if one of the node not present, return -1
            return -1;
        }
        return findLCA(A, B, C);
    }

    private int findLCA(TreeNode root, int B, int C) {

        while (root != null) {
            //in of root less than both and out greater than both
            if (root.left != null && in.get(root.val) < in.get(B) && in.get(root.val) < in.get(C) &&
                    out.get(root.val) > out.get(B) && out.get(root.val) > out.get(C)) {
                root = root.left;
            } else if (root.right != null && in.get(root.val) < in.get(B) && in.get(root.val) < in.get(C) &&
                    out.get(root.val) < out.get(B) && out.get(root.val) < out.get(C)) { //in of root less than both and out less than both
                root = root.right;
            } else {
                return root.val;
            }
        }
        return -1;
    }

    // traversal to find out in and out time of every node
    private void eulerTour(TreeNode root) {

        if (root == null) {
            return;
        }
        in.put(root.val, time++);
        eulerTour(root.left);

        out.put(root.val, time++); //update out time after left-subtree is done
        eulerTour(root.right);
    }
}

