package com.graphs.v;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodGraph {

    private boolean[] visited;
    private HashMap<Integer, ArrayList<Integer>> adjMap;

    public int solve(int[] A) {

        //can't really understand how this algo works
        visited = new boolean[A.length + 1];
        adjMap = new HashMap<>();

        for (int i = 1; i < A.length; i++) {
            ArrayList<Integer> nbrs = adjMap.getOrDefault(A[i], new ArrayList<>());
            nbrs.add(i + 1);
            adjMap.put(A[i], nbrs);

            nbrs = adjMap.getOrDefault(i + 1, new ArrayList<>());
            nbrs.add(A[i]);
            adjMap.put(i + 1, nbrs);
        }

        int connectedComponents = 0;
        for (int i = 1; i < A.length + 1; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i);
            }
        }
        return connectedComponents - 1;
    }

    public void dfs(int node) {
        visited[node] = true;
        ArrayList<Integer> nbrs = adjMap.getOrDefault(node, new ArrayList<>());
        for (Integer nbr : nbrs) {
            if (!visited[nbr]) {
                dfs(nbr);
            }
        }
    }
}

/*
Good Graph
Problem Description

Given a directed graph of N nodes where each node is pointing to any one of the N nodes (can possibly point to itself). Ishu, the coder, is bored and he has discovered a problem out of it to keep himself busy. Problem is as follows:

A node is 'good' if it satisfies one of the following:

1. It is the special node (marked as node 1)
2. It is pointing to the special node (node 1)
3. It is pointing to a good node.
Ishu is going to change pointers of some nodes to make them all 'good'. You have to find the minimum number of pointers to change in order to make all the nodes good (Thus, a Good Graph).

NOTE: Resultant Graph should hold the property that all nodes are good and each node must point to exactly one node.



Problem Constraints
1 <= N <= 105



Input Format
First and only argument is an integer array A containing N numbers all between 1 to N, where i-th number is the number of node that i-th node is pointing to.



Output Format
An Integer denoting minimum number of pointer changes.



Example Input
Input 1:

 [1, 2, 1, 2]
Input 2:

 [3, 1, 3, 1]


Example Output
Output 1:

 1
Output 2:

 1


Example Explanation
Explanation 1:

 Pointer of node 2 is made to point to node 1.
Explanation 2:

 Pointer of node 3 is made to point to node 1.
 */
