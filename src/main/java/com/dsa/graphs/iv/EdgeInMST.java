package com.dsa.graphs.iv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class EdgeInMST {

    private int[] parent;
    private int[] size;

    public int[] solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();

        for (int i = 0; i < B.length; i++) {

            ArrayList<Pair> val = map.getOrDefault(B[i][2], new ArrayList<>());
            val.add(new Pair(B[i][0], B[i][1], i));

            map.put(B[i][2], val);
        }

        int[] ans = new int[B.length];

        for (Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {

            ArrayList<Pair> pairs = entry.getValue();

            for (Pair pair : pairs) {
                int p1 = findParent(pair.node1);
                int p2 = findParent(pair.node2);

                if (p1 != p2) { //can add to MST
                    ans[pair.index] = 1;
                }
            }

            for (Pair pair : pairs) { //add one of the pairs to MST
                unionEdge(pair.node1, pair.node2);
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

    static class Pair {
        int node1;
        int node2;
        int index;

        Pair(int node1, int node2, int index) {
            this.node1 = node1;
            this.node2 = node2;
            this.index = index;
        }
    }
}

