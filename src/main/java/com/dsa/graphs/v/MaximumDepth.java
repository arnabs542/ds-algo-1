package com.dsa.graphs.v;

import java.util.*;

public class MaximumDepth {

    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {

        //create adjacency map
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        boolean[] visited = new boolean[A + 1];

        for (int i = 0; i < B.length; i++) {

            ArrayList<Integer> val = adjMap.getOrDefault(C[i], new ArrayList<>());
            val.add(B[i]);
            adjMap.put(C[i], val);

            val = adjMap.getOrDefault(B[i], new ArrayList<>());
            val.add(C[i]);
            adjMap.put(B[i], val);
        }

        Map<Integer, List<Integer>> levelToNodesMap = new HashMap<>();
        //queue to do BFS
        int size = 1;
        int maxDepth = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        visited[1] = true;

        while (!deque.isEmpty()) {

            Integer currNode = deque.pollFirst();
            size--;

            List<Integer> currLevelNodes = levelToNodesMap.getOrDefault(maxDepth, new ArrayList<>());
            currLevelNodes.add(D[currNode - 1]);
            levelToNodesMap.put(maxDepth, currLevelNodes);

            ArrayList<Integer> nbrs = adjMap.getOrDefault(currNode, new ArrayList<>());
            for (Integer n : nbrs) {
                if (!visited[n]) {
                    visited[n] = true;
                    deque.addLast(n);
                }
            }

            if (size == 0 && !deque.isEmpty()) {
                maxDepth++;
                size = deque.size();
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : levelToNodesMap.entrySet()) {
            Collections.sort(entry.getValue());
            levelToNodesMap.put(entry.getKey(), entry.getValue());
        }

        int[] queriesOutput = new int[E.length];
        for (int i = 0; i < E.length; i++) {
            queriesOutput[i] = getNextGreaterOrEqualElement(F[i],
                    levelToNodesMap.getOrDefault(E[i] % (maxDepth + 1), new ArrayList<>()));
        }
        return queriesOutput;
    }

    //array is sorted
    private int getNextGreaterOrEqualElement(int x, List<Integer> array) {

        int l = 0;
        int r = array.size() - 1;

        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array.get(mid) >= x) {
                ans = array.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

/*
Maximum Depth
Problem Description

Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at maxDepth L mod (MaxDepth + 1) and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required maxDepth are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints
2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106



Input Format
The first argument is an integer A denoting the number of nodes.

The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.

The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node

The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.



Output Format
Return an array of integers where the ith element denotes the answer to ith query.



Example Input
Input 1:

 A = 5
 B = [1, 4, 3, 1]
 C = [5, 2, 4, 4]
 D = [7, 38, 27, 37, 1]
 E = [1, 1, 2]
 F = [32, 18, 26]
Input 2:

 A = 3
 B = [1, 2]
 C = [3, 1]
 D = [7, 15, 27]
 E = [1, 10, 1]
 F = [29, 6, 26]


Example Output
Output 1:

 [37, 37, 27]
Output 2:

 [-1, 7, 27]


Example Explanation
Explanation 1:

      1[7]
     /    \
   5[1]  4[37]
        /    \
       2[38]  3[27]

 Query 1:
    L = 1, X = 32
    Nodes for maxDepth 1 are 5, 4
    Value of Node 5 = 1 < 32
    Value of Node 4 = 37 >= 32
    Ans = 37
Explanation 2:

      1[7]
     /    \
   2[15]  3[27]

 Query 1:
    L = 1, X = 6
    Nodes for maxDepth 1 are 2, 3 having value 15 and 27 respectively.
    Answer = -1 (Since no node is greater or equal to 29).
 Query 1:
    L = 10 % 2 = 0, X = 6
    Nodes for maxDepth 0 is 1 having value 7.
    Answer = 7.
 */
