package com.dsa.graphs.i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {

        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>(); //adjacency map
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> nbr = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            nbr.add(B[i][1]);
            adjMap.put(B[i][0], nbr);
        }

        //queue to do BFS, no need of visited array as its directed graph with no multiple edges.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);

        while (!deque.isEmpty()) {

            Integer curNode = deque.pollFirst();
            ArrayList<Integer> nbrs = adjMap.getOrDefault(curNode, new ArrayList<>());

            for (Integer n : nbrs) {
                if (n == A) {
                    return 1;
                }
                deque.addLast(n);
            }
        }
        return 0;
    }
}

