package com.dsa.graphs.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphBipartiteOrNot {

    private final HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    private boolean isBipartite = true;
    private boolean[] visited;
    private int[] color;

    public int solve(int A, int[][] B) {

        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);

            adjMap.put(B[i][1], val);
        }

        visited = new boolean[A];
        color = new int[A];
        Arrays.fill(color, -1);

        for (Integer n : adjMap.keySet()) { //graph maybe disconnected, so check for all nodes
            if (!visited[n]) {
                dfs(n, 0);
            }
        }
        return isBipartite ? 1 : 0;
    }

    private void dfs(int node, int currColor) {

        color[node] = currColor;
        visited[node] = true;

        for (Integer n : adjMap.getOrDefault(node, new ArrayList<>())) {

            if (color[n] == -1) { //dfs on neighbor with opposite color
                dfs(n, 1 - currColor);
            }
            if (color[n] == currColor) { //if neighbor colored with same color, can't be bipartite
                isBipartite = false;
                return;
            }
        }
    }
}


