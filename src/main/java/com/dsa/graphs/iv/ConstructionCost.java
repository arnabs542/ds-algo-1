package com.dsa.graphs.iv;

import java.util.Arrays;
import java.util.Comparator;

public class ConstructionCost {

    private int[] parent;
    private int[] size;

    public int solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Comparator<int[]> customComp = (a, b) -> {
            return Integer.valueOf(a[2]).compareTo(Integer.valueOf(b[2]));
        };
        Arrays.sort(B, customComp);

        long ans = 0L;
        for (int k = 0; k < B.length; k++) {
            if (union(B[k][0], B[k][1])) {
                ans = (ans + Long.valueOf(B[k][2])) % 1000000007;
            }
        }
        return (int) ans;
    }

    public int findParent(int node) {

        if (parent[node] == node) {
            return node;
        }
        return findParent(parent[node]);
    }

    public boolean union(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);
        if (p1 != p2) {
            if (size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
            return true;
        }
        return false;
    }
}
