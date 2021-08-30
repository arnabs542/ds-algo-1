package com.dsa.trees.iii;

public class CheckForBSTWithOneChild {

    public String solve(int[] A) {

        //in preorder traversal, leaf nodes will come at the last
        //determine min and max among last two nodes
        int min = Math.min(A[A.length - 1], A[A.length - 2]);
        int max = Math.max(A[A.length - 1], A[A.length - 2]);

        for (int i = A.length - 3; i >= 0; i--) {

            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            } else {
                return "NO"; //if current val is between max and min, not possible for a BST
            }
        }
        return "YES";
    }
}


