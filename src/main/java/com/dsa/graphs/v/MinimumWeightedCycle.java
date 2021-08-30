package com.dsa.graphs.v;

import java.util.*;

public class MinimumWeightedCycle {

    private HashMap<Integer, HashSet<Pair>> adjMap;

    public int solve(int A, int[][] B) {

        //algo: remove each edge and do dijkstra.

        adjMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            addEdge(B[i][0], B[i][1], B[i][2]);
        }

        int minWtCycle = Integer.MAX_VALUE;

        for (int i = 0; i < B.length; i++) {

            //remove edge from adjMap
            removeEdge(B[i][0], B[i][1]);

            int[] dist = dijkstra(B[i][0], A, adjMap);
            minWtCycle = Math.min(minWtCycle, B[i][2] + dist[B[i][1]]);

            //add the removed edge back
            addEdge(B[i][0], B[i][1], B[i][2]);
        }
        return minWtCycle == Integer.MAX_VALUE ? -1 : minWtCycle;
    }

    private void addEdge(int sourceNode, int destNode, int weight) {
        HashSet<Pair> val = adjMap.getOrDefault(sourceNode, new HashSet<>());
        val.add(new Pair(destNode, weight));

        adjMap.put(sourceNode, val);

        val = adjMap.getOrDefault(destNode, new HashSet<>());
        val.add(new Pair(sourceNode, weight));

        adjMap.put(destNode, val);
    }

    private void removeEdge(int sourceNode, int destNode) {
        HashSet<Pair> nbrs = adjMap.getOrDefault(sourceNode, new HashSet<>());
        nbrs.remove(new Pair(destNode, 0));
        adjMap.put(sourceNode, nbrs);

        nbrs = adjMap.getOrDefault(destNode, new HashSet<>());
        nbrs.remove(new Pair(sourceNode, 0));
        adjMap.put(destNode, nbrs);
    }

    private int[] dijkstra(int sourceNode, int A, HashMap<Integer, HashSet<Pair>> adjMap) {

        int[] dist = new int[A + 1];
        boolean[] visited = new boolean[A + 1];

        Arrays.fill(dist, Integer.MAX_VALUE / 2);

        //refer notes for algorithm explanation
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> (Integer.valueOf(a.dist))));
        priorityQueue.add(new Pair(sourceNode, 0));
        dist[sourceNode] = 0;

        while (!priorityQueue.isEmpty()) {

            Pair min = priorityQueue.poll();

            if (visited[min.node]) {
                continue;
            }
            visited[min.node] = true;

            for (Pair nbr : adjMap.getOrDefault(min.node, new HashSet<>())) {
                if (dist[nbr.node] > min.dist + nbr.dist) {
                    dist[nbr.node] = min.dist + nbr.dist;
                    priorityQueue.add(new Pair(nbr.node, dist[nbr.node]));
                }
            }
        }

        return dist;
    }

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", dist=" + dist +
                    '}';
        }
    }
}


