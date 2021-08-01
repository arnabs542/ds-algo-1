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

/*
Unique Paths III
Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

Answer is evident here.

 */