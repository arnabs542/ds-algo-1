package com.dsa.graphs.i;

import java.util.ArrayList;
import java.util.HashMap;

public class AnotherBFS {

    private int[] visited;

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {

        if (C == D) {
            return 0;
        }
        visited = new int[A];

        HashMap<Integer, ArrayList<Pair>> adjMap = new HashMap<>();
        //construct adjacency list
        for (int i = 0; i < B.size(); i++) {

            ArrayList<Pair> nbr = adjMap.getOrDefault(B.get(i).get(0), new ArrayList<>());
            nbr.add(new Pair(B.get(i).get(1), B.get(i).get(2)));

            adjMap.put(B.get(i).get(0), nbr);

            nbr = adjMap.getOrDefault(B.get(i).get(1), new ArrayList<>());
            nbr.add(new Pair(B.get(i).get(0), B.get(i).get(2)));

            adjMap.put(B.get(i).get(1), nbr);
        }

        HashMap<Integer, ArrayList<Integer>> weightMap = new HashMap<>();

        ArrayList<Pair> nbrsOfSource = adjMap.getOrDefault(C, new ArrayList<>());
        for (int k = 0; k < nbrsOfSource.size(); k++) {
            ArrayList<Integer> queueList = weightMap.getOrDefault(nbrsOfSource.get(k).weight, new ArrayList<>());
            queueList.add(nbrsOfSource.get(k).node);
            weightMap.put(nbrsOfSource.get(k).weight, queueList);
        }

        for (int i = 1; i < 2 * (A - 1); i++) {

            ArrayList<Integer> nodes = weightMap.getOrDefault(i, new ArrayList<>());

            for (int j = 0; j < nodes.size(); j++) {
                if (nodes.get(j) == D) {
                    return i;
                }
                if (visited[nodes.get(j)] != 1) {
                    visited[nodes.get(j)] = 1;
                    ArrayList<Pair> currNodeNbr = adjMap.getOrDefault(nodes.get(j), new ArrayList<>());

                    for (int k = 0; k < currNodeNbr.size(); k++) {
                        ArrayList<Integer> queueList = weightMap.getOrDefault(i + currNodeNbr.get(k).weight, new ArrayList<>());
                        queueList.add(currNodeNbr.get(k).node);
                        weightMap.put(i + currNodeNbr.get(k).weight, queueList);
                    }
                }
            }
        }
        return -1;
    }

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}

