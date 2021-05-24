package com.graphs.i;

public class NoOfIslands {

    private boolean[][] visited;
    //better way to handle allowed neighbours
    private int[] rows = new int[]{-1, 0, 1, 0, -1, 1, -1, 1};
    private int[] cols = new int[]{0, -1, 0, 1, -1, 1, 1, -1};

    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !visited[i][j]) { //do dfs on all 1's, separate islands will be counted
                    count++;
                    dfs(i, j, A);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] A) {
        visited[i][j] = true;
        for (int k = 0; k < rows.length; k++) { //go in all directions
            int nextI = i + rows[k];
            int nextJ = j + cols[k];
            //do dfs only if neighbour is 1
            if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length &&
                    !visited[nextI][nextJ] && A[nextI][nextJ] == 1) {
                dfs(nextI, nextJ, A);
            }
        }
    }
}

/*

Number of islands
Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1



Input Format
The only argument given is the integer matrix A.



Output Format
Return the number of islands.



Example Input
Input 1:

 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]


Example Output
Output 1:

 2
Output 2:

 5


Example Explanation
Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.
 */