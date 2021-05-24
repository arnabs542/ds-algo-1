package com.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class DistanceOfNearestCell {

    public int[][] solve(int[][] A) {

        int[] rows = new int[]{-1, 0, 0, 1};
        int[] cols = new int[]{0, -1, 1, 0};

        boolean[][] visited = new boolean[A.length][A[0].length];

        //queue for doing BFS
        Deque<Pair> deque = new ArrayDeque<>();

        //add all 1's to the queue, these belong to first level
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    deque.addLast(new Pair(i, j));
                    visited[i][j] = true;
                    A[i][j] = 0; //distance is 0, update it in original array
                }
            }
        }

        int level = 1;
        int size = deque.size();

        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();
            size--;

            for (int k = 0; k < rows.length; k++) {

                int nexti = pair.i + rows[k];
                int nextj = pair.j + cols[k];

                if (nexti >= 0 && nexti < A.length && nextj >= 0 && nextj < A[0].length
                        && !visited[nexti][nextj]) {
                    A[nexti][nextj] = level;
                    visited[nexti][nextj] = true;
                    deque.addLast(new Pair(nexti, nextj));
                }
            }
            if (size == 0 && !deque.isEmpty()) {
                level++;
                size = deque.size();
            }
        }
        return A;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
/*
Distance of nearest cell
Problem Description

Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 present in the matrix.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 1



Input Format
The first argument given is the integer matrix A.



Output Format
Return the matrix B.



Example Input
Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1]
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
     ]


Example Output
Output 1:

 [
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4]
 ]


Example Explanation
Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 */