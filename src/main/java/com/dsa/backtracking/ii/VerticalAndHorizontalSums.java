package com.dsa.backtracking.ii;

public class VerticalAndHorizontalSums {

    private int ans = 0;

    public int solve(int A, int[][] B, int C) {

        ans = checkSubArraySum(B, C) ? 1 : 0; //check if without any operation we can achieve

        if (ans == 1) {
            return ans;
        }

        checkPossibility(0, A, B, C);
        return ans;
    }

    private void checkPossibility(int cell, int A, int[][] B, int C) {

        if (ans == 1 || A == 0 || (cell == B.length * B[0].length)) {
            return;
        }

        int i = cell / B[0].length;
        int j = cell % B[0].length;

        if ((B[i][j] > 0)) {//only +ve no.s will cause sum to exceed C, so operate only them

            B[i][j] = -B[i][j]; //operate

            if (checkSubArraySum(B, C)) {//if array satisfies condition, return
                ans = 1;
                return;
            }
            checkPossibility(cell + 1, A - 1, B, C);

            B[i][j] = -B[i][j]; //undo (backtrack)
        }
        //check next cell
        checkPossibility(cell + 1, A, B, C);
    }

    //returns true if there is no subarray (horizontal & vertical) with sum > C
    private boolean checkSubArraySum(int[][] B, int C) {

        for (int i = 0; i < B.length; i++) {
            int maxSum = maxSubArraySum(B[i]);
            if (maxSum > C) {
                return false;
            }
        }

        int[] arr;
        for (int i = 0; i < B[0].length; i++) {
            arr = new int[B.length];
            for (int k = 0; k < B.length; k++) {
                arr[k] = B[k][i];
            }
            int maxSum = maxSubArraySum(arr);
            if (maxSum > C) {
                return false;
            }
        }
        return true;
    }

    // Kadane's Algorithm (doesn't work if all are -ve numbers)
    private int maxSubArraySum(int[] A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < A.length; i++) {
            maxEndingHere += A[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxEndingHere = Math.max(maxEndingHere, 0);
        }
        return maxSoFar;
    }
}

