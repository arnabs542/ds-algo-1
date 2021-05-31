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

/*

Another BFS
Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 105

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A



Input Format
The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.



Output Format
Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.



Example Input
Input 1:


A = 6
B = [   [2, 5, 1]
        [1, 3, 1]
        [0, 5, 2]
        [0, 2, 2]
        [1, 4, 1]
        [0, 1, 1] ]
C = 3
D = 2
Input 2:

A = 2
B = [   [0, 1, 1]
    ]
C = 0
D = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.
Explanation 2:

 Path will be 0-> 1.
 */