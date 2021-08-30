package com.dsa.graphs.iv;

import java.util.HashSet;

public class GymTrainer {

    private int[] parent;
    private int[] size;
    private int noOfNodes;

    public int solve(int A, int[][] B, int[][] C) {

        HashSet<Integer> walkingFriends = new HashSet<>();
        HashSet<Integer> talkingFriends = new HashSet<>();

        for (int i = 0; i < B.length; i++) {
            walkingFriends.add(B[i][0]);
            walkingFriends.add(B[i][1]);
        }

        for (int i = 0; i < C.length; i++) {
            if (walkingFriends.contains(C[i][0]) || walkingFriends.contains(C[i][1])) {
                return 0;
            }
            talkingFriends.add(C[i][0]);
            talkingFriends.add(C[i][1]);
        }

        noOfNodes = A;
        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < B.length; i++) {
            unionEdge(B[i][0], B[i][1]);
        }
        for (int i = 0; i < C.length; i++) {
            unionEdge(C[i][0], C[i][1]);
        }

        return (int) power(2, noOfNodes, 1000000007) % 1000000007;
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
            noOfNodes--;
        }
    }

    private long power(long a, long b, long p) {

        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return 0L;
        } else if (b % 2 == 0) {
            return power(((a % p) * (a % p)) % p, b / 2, p) % p;
        } else {
            return ((a % p) * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
        }
    }
}


