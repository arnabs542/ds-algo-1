package com.dsa.graphs.iv;

public class Batches {

    private int[] parent;
    private int[] size;

    public int solve(int A, int[] B, int[][] C, int D) {

        parent = new int[A + 1];
        size = new int[A + 1];

        int ans = 0;
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
            size[i] = B[i - 1];
        }
        for (int i = 0; i < C.length; i++) {
            unionEdge(C[i][0], C[i][1]);
        }
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i && size[i] >= D) {
                ans++;
            }
        }
        return ans;
    }

    private int findParent(int node) {

        if (node == parent[node]) {
            return node;
        }
        return findParent(parent[node]);
    }

    private void unionEdge(int node1, int node2) {

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
        }
    }
}

