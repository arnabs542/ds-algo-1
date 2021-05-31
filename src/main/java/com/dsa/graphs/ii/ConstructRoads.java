package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ConstructRoads {

    public int solve(int A, int[][] B) {

        int mod = 1000000007;

        //create adjacency map
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);

            adjMap.put(B[i][1], val);
        }

        //color the graph with only 2 colors i.e 0 or 1
        int[] colors = new int[A + 1];
        boolean[] visited = new boolean[A + 1];

        //queue to do BFS
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        colors[1] = 1;
        visited[1] = true;

        while (!deque.isEmpty()) {

            Integer curNode = deque.pollFirst();

            ArrayList<Integer> nbrs = adjMap.getOrDefault(curNode, new ArrayList<>());

            for (Integer n : nbrs) {
                if (!visited[n]) {
                    visited[n] = true;
                    colors[n] = 1 - colors[curNode]; //color neighbour with opposite color
                    deque.addLast(n);
                }
            }
        }

        //refer class notes for logic
        int color1 = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == 0) {
                color1++;
            }
        }
        long ans = (Long.valueOf(color1) * Long.valueOf(A - color1)) % mod - (A - 1L) + mod;
        return (int) (ans % mod);
    }
}

/*
Construct Roads
Problem Description

A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 10^9 + 7.

NOTE: All cities can be visited from any city.



Problem Constraints
1 <= A <= 105

1 <= B[i][0], B[i][1] <= N



Input Format
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .



Output Format
Return an integer denoting the maximum number of roads king can construct.



Example Input
Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]


Example Output
Output 1:

 0
Output 2:

 2


Example Explanation
Explanation 1:

 We can't construct any new roads such that the country remains bipartite.
Explanation 2:

 We can add two roads between cities (4, 2) and (4, 5).
 */