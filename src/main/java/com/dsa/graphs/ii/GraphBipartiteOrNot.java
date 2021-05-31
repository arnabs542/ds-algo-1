package com.dsa.graphs.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphBipartiteOrNot {

    private final HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    private boolean isBipartite = true;
    private boolean[] visited;
    private int[] color;

    public int solve(int A, int[][] B) {

        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);

            adjMap.put(B[i][1], val);
        }

        visited = new boolean[A];
        color = new int[A];
        Arrays.fill(color, -1);

        for (Integer n : adjMap.keySet()) { //graph maybe disconnected, so check for all nodes
            if (!visited[n]) {
                dfs(n, 0);
            }
        }
        return isBipartite ? 1 : 0;
    }

    private void dfs(int node, int currColor) {

        color[node] = currColor;
        visited[node] = true;

        for (Integer n : adjMap.getOrDefault(node, new ArrayList<>())) {

            if (color[n] == -1) { //dfs on neighbor with opposite color
                dfs(n, 1 - currColor);
            }
            if (color[n] == currColor) { //if neighbor colored with same color, can't be bipartite
                isBipartite = false;
                return;
            }
        }
    }
}

/*
Check whether the graph is bipartite or not
Problem Description

Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A



Input Format
The first argument given is an integer A.

The second argument given is the matrix B.



Output Format
Return 1 if the given graph is bipartide else return 0.



Example Input
Input 1:

A = 2
B = [ [0, 1] ]
Input 2:

A = 3
B = [ [0, 1], [0, 2], [1, 2] ]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

Put 0 and 1 into 2 different subsets.
Explanation 2:


It is impossible to break the graph down to make two different subsets for bipartite matching
 */
