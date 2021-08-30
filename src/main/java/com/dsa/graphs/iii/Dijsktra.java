package com.dsa.graphs.iii;

import java.util.*;

public class Dijsktra {

    public int[] solve(int A, int[][] B, int C) {

        int[] dist = new int[A];
        boolean[] visited = new boolean[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> adjMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            ArrayList<Pair<Integer, Integer>> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(new Pair<>(B[i][2], B[i][1]));

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(new Pair<>(B[i][2], B[i][0]));

            adjMap.put(B[i][1], val);
        }

        Comparator<Pair<Integer, Integer>> customComparator = (a, b) -> {
            return (a.dist).compareTo(b.dist);
        };

        //refer notes for algorithm explanation
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(customComparator);
        priorityQueue.add(new Pair<>(0, C));
        dist[C] = 0;

        while (!priorityQueue.isEmpty()) {

            Pair<Integer, Integer> min = priorityQueue.poll();

            if (visited[min.node]) {
                continue;
            }
            visited[min.node] = true;

            for (Pair<Integer, Integer> nbr : adjMap.getOrDefault(min.node, new ArrayList<>())) {
                if (dist[nbr.node] > min.dist + nbr.dist) {
                    dist[nbr.node] = min.dist + nbr.dist;
                    priorityQueue.add(new Pair<>(dist[nbr.node], nbr.node));
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    static class Pair<T, U> {
        T dist;
        U node;

        Pair(T t, U u) {
            this.dist = t;
            this.node = u;
        }
    }
}

