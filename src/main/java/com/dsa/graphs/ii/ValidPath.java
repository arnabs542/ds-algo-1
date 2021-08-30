package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidPath {

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        int[] rows = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] cols = new int[]{-1, 1, 0, 1, -1, 0, -1, 1};

        boolean[][] visited = new boolean[A + 1][B + 1];

        if (inCircle(0, 0, C, D, E, F)) {
            return "NO";
        }

        //queue for doing BFS
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();

            if (pair.i == A && pair.j == B) {
                return "YES";
            }

            for (int k = 0; k < rows.length; k++) {

                int nexti = pair.i + rows[k];
                int nextj = pair.j + cols[k];

                if (nexti >= 0 && nexti < (A + 1) && nextj >= 0 && nextj < (B + 1)
                        && !visited[nexti][nextj] && !inCircle(nexti, nextj, C, D, E, F)) {
                    visited[nexti][nextj] = true;
                    deque.addLast(new Pair(nexti, nextj));
                }
            }
        }
        return "NO";
    }

    private boolean inCircle(int x, int y, int C, int D, int[] E, int[] F) {
        for (int i = 0; i < C; i++) {
            if (((x - E[i]) * (x - E[i]) + (y - F[i]) * (y - F[i])) <= (D * D))
                return true;
        }
        return false;
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

