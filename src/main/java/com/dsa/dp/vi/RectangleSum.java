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
