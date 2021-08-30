package com.dsa.graphs.v;

import java.util.*;

public class PossibilityOfFinishing {

    public int solve(int A, int[] B, int[] C) {

        //topological sort algo
        int[] inDegree = new int[A + 1];

        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < B.length; i++) {

            List<Integer> nbrs = adjMap.getOrDefault(B[i], new ArrayList<>());
            nbrs.add(C[i]);
            adjMap.put(B[i], nbrs);

            inDegree[C[i]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int totalElements = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            totalElements++;

            for (Integer nbr : adjMap.getOrDefault(currentNode, new ArrayList<>())) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }
        return totalElements == A ? 1 : 0;
    }
}


