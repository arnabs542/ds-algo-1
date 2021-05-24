package com.graphs.iv;

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

/*

Gym Trainer
Problem Description

You are the trainer of a gym and there are A people who come to your gym.

Some of them are friends because they walk together, and some of them are friends because they talk together.
But people become possessive about each other, so a person cannot walk with one friend and talk with another. Although he can walk with two or more people or talk with two or more people.

You being the trainer, decided to suggest each one of the 2 possible diets. But friends, being friends will always have the same diet as all the other friends are having.

Find and return the number of ways you can suggest each of them a diet.

As the number of ways can be huge, return the answer modulo 109+7.

NOTE: If there is any person who walks with one person and talks with the another person, then you may return 0.



Problem Constraints
1 <= A, N, M <= 105

1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A



Input Format
The first argument contains an integer A, representing the number of people.
The second argument contains a 2-D integer array B of size N x 2, where B[i][0] and B[i][1] are friends because they walk together.
The third argument contains a 2-D integer array C of size M x 2, where C[i][0] and C[i][1] are friends because they talk together.



Output Format
Return an integer representing the number of ways to suggest one of the two diets to the people.



Example Input
Input 1:

 A = 4
 B = [
       [1, 2]
     ]
 C = [
       [3, 4]
     ]
Input 2:

 A = 3
 B = [
       [1, 2]
     ]
 C = [
       [1, 3]
     ]


Example Output
Output 1:

 4
Output 2:

 0


Example Explanation
Explanation 1:

 There are four ways to suggest the diet:
 Diet-1 to (1, 2) and Diet-2 to (3, 4).
 Diet-1 to (1, 2) and Diet-1 to (3, 4).
 Diet-2 to (1, 2) and Diet-1 to (3, 4).
 Diet-2 to (1, 2) and Diet-2 to (3, 4).

Explanation 2:

 Person 1 walks with person 2 and talks with person 3. So, we will return 0.
 */
