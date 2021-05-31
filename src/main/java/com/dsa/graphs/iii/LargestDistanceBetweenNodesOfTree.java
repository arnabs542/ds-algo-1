package com.dsa.graphs.iii;

import java.util.*;

public class LargestDistanceBetweenNodesOfTree {

    int longestPath = Integer.MIN_VALUE;
    private HashMap<Integer, ArrayList<Integer>> adjMap;
    private boolean[] visited;

    public int solve(int[] A) {

        int rootNode = 0;

        //create adjacency map
        adjMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {

            if (A[i] == -1) {
                rootNode = i;
                continue;
            }

            ArrayList<Integer> val = adjMap.getOrDefault(i, new ArrayList<>());
            val.add(A[i]);

            adjMap.put(i, val);

            val = adjMap.getOrDefault(A[i], new ArrayList<>());
            val.add(i);

            adjMap.put(A[i], val);
        }

        visited = new boolean[A.length];
        int node1 = bfs(rootNode); //bfs from root node to find farthest node

        visited = new boolean[A.length];
        dfs(node1); //dfs from node1 to find longest path

        return longestPath;
    }

    private int bfs(int node) {

        //queue to do BFS
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(node);
        visited[node] = true;

        Integer curNode = node;

        while (!deque.isEmpty()) {

            curNode = deque.pollFirst();

            ArrayList<Integer> nbrs = adjMap.getOrDefault(curNode, new ArrayList<>());
            for (Integer n : nbrs) {
                if (!visited[n]) {
                    visited[n] = true;
                    deque.addLast(n);
                }
            }
        }
        return curNode; //last popped
    }

    private void dfs(int node) {

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 0)); //start DFS from node

        //iterative DFS
        while (!stack.empty()) {

            Pair currPair = stack.pop();

            if (visited[currPair.node]) {
                continue;
            }
            visited[currPair.node] = true;
            longestPath = Math.max(longestPath, currPair.dist); //update

            ArrayList<Integer> nbr = adjMap.getOrDefault(currPair.node, new ArrayList<>());
            for (Integer n : nbr) {
                stack.push(new Pair(n, currPair.dist + 1));
            }
        }
    }

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

/*

Largest Distance between nodes of a Tree
Problem Description

Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints
2 <= |A| <= 40000



Input Format
First and only argument is vector A



Output Format
Return the length of the longest path



Example Input
Input 1:


A = [-1, 0]
Input 2:


A = [-1, 0, 0]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 Path is 0 -> 1.
Explanation 2:

 Path is 1 -> 0 -> 2.
 */