package com.dsa.graphs.v;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodGraph {

    private boolean[] visited;
    private HashMap<Integer, ArrayList<Integer>> adjMap;

    public int solve(int[] A) {

        //can't really understand how this algo works
        visited = new boolean[A.length + 1];
        adjMap = new HashMap<>();

        for (int i = 1; i < A.length; i++) {
            ArrayList<Integer> nbrs = adjMap.getOrDefault(A[i], new ArrayList<>());
            nbrs.add(i + 1);
            adjMap.put(A[i], nbrs);

            nbrs = adjMap.getOrDefault(i + 1, new ArrayList<>());
            nbrs.add(A[i]);
            adjMap.put(i + 1, nbrs);
        }

        int connectedComponents = 0;
        for (int i = 1; i < A.length + 1; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i);
            }
        }
        return connectedComponents - 1;
    }

    public void dfs(int node) {
        visited[node] = true;
        ArrayList<Integer> nbrs = adjMap.getOrDefault(node, new ArrayList<>());
        for (Integer nbr : nbrs) {
            if (!visited[nbr]) {
                dfs(nbr);
            }
        }
    }
}


