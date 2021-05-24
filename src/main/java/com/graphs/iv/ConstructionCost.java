package com.graphs.iv;

import java.util.Arrays;
import java.util.Comparator;

public class ConstructionCost {

    private int[] parent;
    private int[] size;

    public int solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Comparator<int[]> customComp = (a, b) -> {
            return Integer.valueOf(a[2]).compareTo(Integer.valueOf(b[2]));
        };
        Arrays.sort(B, customComp);

        long ans = 0L;
        for (int k = 0; k < B.length; k++) {
            if (union(B[k][0], B[k][1])) {
                ans = (ans + Long.valueOf(B[k][2])) % 1000000007;
            }
        }
        return (int) ans;
    }

    public int findParent(int node) {

        if (parent[node] == node) {
            return node;
        }
        return findParent(parent[node]);
    }

    public boolean union(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);
        if (p1 != p2) {
            if (size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
            return true;
        }
        return false;
    }
}
/*

Construction Cost
Problem Description

Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.



Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109



Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]



Output Format
Return an integer denoting the minimum construction cost.



Example Input
Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output
Output 1:

9
Output 2:

37


Example Explanation
Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.
Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */