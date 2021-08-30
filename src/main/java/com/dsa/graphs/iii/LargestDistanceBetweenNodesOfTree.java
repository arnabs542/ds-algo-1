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

