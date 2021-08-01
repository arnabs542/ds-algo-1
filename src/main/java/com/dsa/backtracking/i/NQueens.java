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

/*
NQueens
Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10



Input Format
First argument is an integer n denoting the size of chessboard



Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input
Input 1:

A = 4
Input 2:

A = 1


Example Output
Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation
Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:

 */