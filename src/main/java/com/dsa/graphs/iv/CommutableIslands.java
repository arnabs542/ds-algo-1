package com.dsa.graphs.iv;

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIslands {

    private int[] parent;
    private int[] size;

    // Minimum spanning tree
    // refer class notes for explanation
    public int solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Comparator<int[]> customComparator = (a, b) -> {
            return Integer.valueOf(a[2]).compareTo(Integer.valueOf(b[2]));
        };
        Arrays.sort(B, customComparator);

        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            if (unionEdge(B[i][0], B[i][1])) {
                ans += B[i][2];
            }
        }
        return ans;
    }

    private int findParent(int node) {

        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private boolean unionEdge(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (p1 != p2) {
            if (size[p1] < size[p2]) {
                size[p2] += size[p1];
                parent[p1] = p2;
            } else {
                size[p1] += size[p2];
                parent[p2] = p1;
            }
            return true;
        }
        return false;
    }
}


