package com.dsa.graphs.iii;

import java.util.*;

public class SpecialPath {

    public int solve(int[] A, int[][] B, int C, int D) {

        //dist[i][j][k] means dist from source to ith node with j special and k non-special
        int[][][] dist = new int[A.length + 1][10 + 1][10 + 1];

        //initialize to max value
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE / 2);
            }
        }

        //build adjacency map
        HashMap<Integer, ArrayList<Pair<Integer, Integer, Integer, Integer>>> adjMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            ArrayList<Pair<Integer, Integer, Integer, Integer>> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(new Pair<>(B[i][2], B[i][1]));

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(new Pair<>(B[i][2], B[i][0]));

            adjMap.put(B[i][1], val);
        }

        //custom comparator for priority queue
        Comparator<Pair<Integer, Integer, Integer, Integer>> customComparator = (a, b) -> {
            return (a.dist).compareTo(b.dist);
        };

        //refer notes for algorithm explanation
        PriorityQueue<Pair<Integer, Integer, Integer, Integer>> priorityQueue = new PriorityQueue<>(customComparator);

        if (A[0] == 1) { //source node is special
            dist[1][1][0] = 0;
            priorityQueue.add(new Pair<>(0, 1, 1, 0));
        } else {
            dist[1][0][1] = 0;
            priorityQueue.add(new Pair<>(0, 1, 0, 1));
        }

        while (!priorityQueue.isEmpty()) {

            Pair<Integer, Integer, Integer, Integer> min = priorityQueue.poll();

            //found answer, so return
            if (min.special >= D && min.nonSpecial >= C && min.node == A.length) {
                return min.dist;
            }

            for (Pair<Integer, Integer, Integer, Integer> nbr : adjMap.getOrDefault(min.node, new ArrayList<>())) {

                Pair<Integer, Integer, Integer, Integer> newPair =
                        new Pair<>(min.dist + nbr.dist, nbr.node, min.special, min.nonSpecial);

                //we are saving space by using Math.min, as we need atleast X special or non-special
                //so even with 15 nodes we store answer in dist[i][10][j] and not dist[i][15][j] to save space
                if (A[nbr.node - 1] == 1) {
                    newPair.special = Math.min(10, newPair.special + 1);
                } else {
                    newPair.nonSpecial = Math.min(10, newPair.nonSpecial + 1);
                }

                if (dist[nbr.node][newPair.special][newPair.nonSpecial] > min.dist + nbr.dist) {

                    dist[nbr.node][newPair.special][newPair.nonSpecial] = min.dist + nbr.dist;
                    priorityQueue.add(newPair);
                }
            }
        }
        return -1;
    }

    static class Pair<T, U, V, E> {
        T dist;
        U node;
        V special;
        E nonSpecial;

        Pair(T dist, U node, V special, E nonSpecial) {
            this.dist = dist;
            this.node = node;
            this.special = special;
            this.nonSpecial = nonSpecial;
        }

        Pair(T dist, U node) {
            this.dist = dist;
            this.node = node;
        }
    }
}


