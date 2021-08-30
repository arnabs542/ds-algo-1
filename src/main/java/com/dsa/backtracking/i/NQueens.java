package com.dsa.backtracking.i;

import java.util.ArrayList;

public class NQueens {

    private boolean[] visitedColumns;
    private boolean[] visitedDiagonal1;
    private boolean[] visitedDiagonal2;

    ArrayList<ArrayList<String>> ans;

    public ArrayList<ArrayList<String>> solveNQueens(int N) {
        ans = new ArrayList<>();

        visitedColumns = new boolean[N]; //marks columns where queen can't be placed
        visitedDiagonal1 = new boolean[2 * N]; //marks \ diagonal where queen can't be placed, col-row value is same
        visitedDiagonal2 = new boolean[2 * N]; //marks / diagonal where queen can't be placed, col+row value is same

        recurse(0, N, new ArrayList<>());

        return ans;
    }

    private void recurse(int row, int N, ArrayList<String> A) {

        if (row == N) {
            ans.add(new ArrayList<>(A));
            return;
        }
        // keep recursing until its possible to place a queen, if not possible at any step backtrack
        // and re-place queen again in diff col in previous row and continue recursing
        for (int col = 0; col < N; col++) {

            if (!visitedColumns[col]
                    && !visitedDiagonal1[col - row + N]
                    && !visitedDiagonal2[col + row]) {

                A.add(constructRow(col, N));

                visitedColumns[col] = true;
                visitedDiagonal1[col - row + N] = true;
                visitedDiagonal2[col + row] = true;

                recurse(row + 1, N, A);

                A.remove(A.size() - 1); //remove last added and check possibility for another column (backtracking)

                visitedColumns[col] = false;
                visitedDiagonal1[col - row + N] = false;
                visitedDiagonal2[col + row] = false;
            }
        }
    }

    // returns row as a string like ....Q...
    private String constructRow(int colIndex, int N) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (colIndex == i) {
                s.append('Q');
            } else {
                s.append('.');
            }
        }
        return s.toString();
    }
}

