package com.dsa.backtracking.i;

public class UniquePathsIII {

    //better way to handle allowed neighbours
    private int[] rows = new int[]{-1, 0, 1, 0};
    private int[] cols = new int[]{0, -1, 0, 1};

    private int ans;

    public int solve(int[][] A) {
        ans = 0;

        int zeroCount = 0; //stores no. of zeroes in the array
        int startRow = -1; //start row index
        int startCol = -1; //start col index

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    zeroCount++;
                } else if (A[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        recurse(startRow, startCol, zeroCount, -1, A);
        return ans;
    }

    private void recurse(int row, int col, int zeroCount, int visitedCount, int[][] A) {

        if (A[row][col] == 2) {
            if (zeroCount == visitedCount) {
                ans++;
            }
            return;
        }

        A[row][col] = -1; //mark as visited
        visitedCount++; //visitedCount increases

        for (int k = 0; k < rows.length; k++) { //go in all directions
            int nextI = row + rows[k];
            int nextJ = col + cols[k];

            if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length
                    && A[nextI][nextJ] != -1) {
                recurse(nextI, nextJ, zeroCount, visitedCount, A);
            }
        }

        //backtracking logic, undo now to take different path (as no other direction to go)
        A[row][col] = 0; //undo visited
        visitedCount--; //visitedCount decreases
    }
}

