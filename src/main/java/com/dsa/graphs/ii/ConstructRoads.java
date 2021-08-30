package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ConstructRoads {

    public int solve(int A, int[][] B) {

        int mod = 1000000007;

        //create adjacency map
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);

            adjMap.put(B[i][1], val);
        }

        //color the graph with only 2 colors i.e 0 or 1
        int[] colors = new int[A + 1];
        boolean[] visited = new boolean[A + 1];

        //queue to do BFS
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        colors[1] = 1;
        visited[1] = true;

        while (!deque.isEmpty()) {

            Integer curNode = deque.pollFirst();

            ArrayList<Integer> nbrs = adjMap.getOrDefault(curNode, new ArrayList<>());

            for (Integer n : nbrs) {
                if (!visited[n]) {
                    visited[n] = true;
                    colors[n] = 1 - colors[curNode]; //color neighbour with opposite color
                    deque.addLast(n);
                }
            }
        }

        //refer class notes for logic
        int color1 = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == 0) {
                color1++;
            }
        }
        long ans = (Long.valueOf(color1) * Long.valueOf(A - color1)) % mod - (A - 1L) + mod;
        return (int) (ans % mod);
    }
}

