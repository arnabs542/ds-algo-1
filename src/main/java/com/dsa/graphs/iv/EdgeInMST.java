package com.dsa.graphs.iv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class EdgeInMST {

    private int[] parent;
    private int[] size;

    public int[] solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();

        for (int i = 0; i < B.length; i++) {

            ArrayList<Pair> val = map.getOrDefault(B[i][2], new ArrayList<>());
            val.add(new Pair(B[i][0], B[i][1], i));

            map.put(B[i][2], val);
        }

        int[] ans = new int[B.length];

        for (Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {

            ArrayList<Pair> pairs = entry.getValue();

            for (Pair pair : pairs) {
                int p1 = findParent(pair.node1);
                int p2 = findParent(pair.node2);

                if (p1 != p2) { //can add to MST
                    ans[pair.index] = 1;
                }
            }

            for (Pair pair : pairs) { //add one of the pairs to MST
                unionEdge(pair.node1, pair.node2);
            }
        }
        return ans;
    }

    private int findParent(int node) {

        if (node == parent[node]) {
            return node;
        }
        return findParent(parent[node]);
    }

    private void unionEdge(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (p1 != p2) {
            if (size[p1] < size[p2]) {
                size[p2] += size[p1];
                parent[p1] = p2;
            } else {
                size[p1] += size[p2];
                parent[p2] = p1;
            }
        }
    }

    static class Pair {
        int node1;
        int node2;
        int index;

        Pair(int node1, int node2, int index) {
            this.node1 = node1;
            this.node2 = node2;
            this.index = index;
        }
    }
}

/*
Edge in MST
Problem Description

Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].

For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:

The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].


Problem Constraints
1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A

1 <= B[i][1] <= 103



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].



Output Format
Return an one-dimensional binary array of size M denoting answer for each edge.



Example Input
Input 1:

 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]


Example Output
Output 1:

 [1, 1, 0]


Example Explanation
Explanation 1:

 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0]
 */