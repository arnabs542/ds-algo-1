package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class KnightOnChessBoard {

    public int knight(int A, int B, int C, int D, int E, int F) {

        if (C == E && D == F) {
            return 0;
        }

        int[] rows = new int[]{-2, -2, 1, 1, 2, 2, -1, -1};
        int[] cols = new int[]{-1, 1, 2, -2, -1, 1, 2, -2};

        boolean[][] visited = new boolean[A][B];

        //queue for doing BFS
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(C - 1, D - 1));
        visited[C - 1][D - 1] = true;

        int level = 0;
        int size = deque.size();

        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();
            size--;

            if (pair.i == E - 1 && pair.j == F - 1) {
                return level;
            }

            for (int k = 0; k < rows.length; k++) {

                int nexti = pair.i + rows[k];
                int nextj = pair.j + cols[k];

                if (nexti >= 0 && nexti < A && nextj >= 0 && nextj < B && !visited[nexti][nextj]) {
                    visited[nexti][nextj] = true;
                    deque.addLast(new Pair(nexti, nextj));
                }
            }
            if (size == 0 && !deque.isEmpty()) {
                level++;
                size = deque.size();
            }
        }
        return -1;
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

