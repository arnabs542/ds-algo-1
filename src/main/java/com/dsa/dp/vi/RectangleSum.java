package com.dsa.dp.vi;

public class RectangleSum {
    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {//fix column left
            for (int j = i; j < m; j++) {//fix column right

                //kadane's algorithm
                int maxSoFar = Integer.MIN_VALUE;
                int maxEndingHere = 0;

                for (int r = 0; r < n; r++) { //iterate all rows
                    maxEndingHere += subArraySum(A[r], i, j);
                    maxSoFar = Math.max(maxSoFar, maxEndingHere);
                    maxEndingHere = Math.max(maxEndingHere, 0);
                }
                ans = Math.max(ans, maxSoFar);
            }
        }
        return ans;
    }

    private int subArraySum(int[] A, int startCol, int endCol) {
        int sum = 0;
        for (int i = startCol; i <= endCol; i++) {
            sum += A[i];
        }
        return sum;
    }
}
/*
RECTANGLE SUM
Problem Description

Given a matrix of integers A of size N x M.

Calculate the sum of all submatrices and return the maximum among all those sums.

NOTE: Empty submatrix also need to be considered.



Problem Constraints
1 <= N, M <= 100
-10000 <= A[i] <= 10000



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the maximum sum among all those sums of all possible submatrices.



Example Input
Input 1:

 A = [
       [1, 3, -2]
       [1, 4, 6]
       [-4, -2, 1]
     ]
Input 2:


A = [
      [-1, -1]
      [-1, -1]
    ]


Example Output
Output 1:

 13
Output 2:

 0


Example Explanation
Explanation 1:

 Submatrix giving maximum sum is :
    [
       [1, 3, -2]
       [1, 4, 6]
    ]
Explanation 2:

 Sum of empty submatrix will be 0.

 */