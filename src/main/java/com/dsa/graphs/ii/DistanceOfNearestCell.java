package com.dsa.graphs.ii;

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
