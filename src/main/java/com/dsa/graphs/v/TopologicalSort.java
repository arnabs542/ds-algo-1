package com.dsa.graphs.v;

import java.util.*;

public class TopologicalSort {

    public int[] solve(int A, int[][] B) {

        //topological sort algo
        int[] inDegree = new int[A + 1];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < B.length; i++) {

            List<Integer> nbrs = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            nbrs.add(B[i][1]);
            adjMap.put(B[i][0], nbrs);

            inDegree[B[i][1]]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[A];
        int length = 0;
        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            ans[length++] = currentNode;

            for (Integer nbr : adjMap.getOrDefault(currentNode, new ArrayList<>())) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }
        return length == A ? ans : new int[]{};
    }
}


