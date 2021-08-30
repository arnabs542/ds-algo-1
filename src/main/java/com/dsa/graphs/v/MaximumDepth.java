package com.dsa.graphs.v;

import java.util.*;

public class MaximumDepth {

    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {

        //create adjacency map
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        boolean[] visited = new boolean[A + 1];

        for (int i = 0; i < B.length; i++) {

            ArrayList<Integer> val = adjMap.getOrDefault(C[i], new ArrayList<>());
            val.add(B[i]);
            adjMap.put(C[i], val);

            val = adjMap.getOrDefault(B[i], new ArrayList<>());
            val.add(C[i]);
            adjMap.put(B[i], val);
        }

        Map<Integer, List<Integer>> levelToNodesMap = new HashMap<>();
        //queue to do BFS
        int size = 1;
        int maxDepth = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        visited[1] = true;

        while (!deque.isEmpty()) {

            Integer currNode = deque.pollFirst();
            size--;

            List<Integer> currLevelNodes = levelToNodesMap.getOrDefault(maxDepth, new ArrayList<>());
            currLevelNodes.add(D[currNode - 1]);
            levelToNodesMap.put(maxDepth, currLevelNodes);

            ArrayList<Integer> nbrs = adjMap.getOrDefault(currNode, new ArrayList<>());
            for (Integer n : nbrs) {
                if (!visited[n]) {
                    visited[n] = true;
                    deque.addLast(n);
                }
            }

            if (size == 0 && !deque.isEmpty()) {
                maxDepth++;
                size = deque.size();
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : levelToNodesMap.entrySet()) {
            Collections.sort(entry.getValue());
            levelToNodesMap.put(entry.getKey(), entry.getValue());
        }

        int[] queriesOutput = new int[E.length];
        for (int i = 0; i < E.length; i++) {
            queriesOutput[i] = getNextGreaterOrEqualElement(F[i],
                    levelToNodesMap.getOrDefault(E[i] % (maxDepth + 1), new ArrayList<>()));
        }
        return queriesOutput;
    }

    //array is sorted
    private int getNextGreaterOrEqualElement(int x, List<Integer> array) {

        int l = 0;
        int r = array.size() - 1;

        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array.get(mid) >= x) {
                ans = array.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}


