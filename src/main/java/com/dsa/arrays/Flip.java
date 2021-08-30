package com.dsa.arrays;

public class Flip {

    public int[] flip(String A) {

        int[] c = new int[A.length()];

        boolean atLeastOneZero = false;

        for (int i = 0; i < c.length; i++) {
            if (A.charAt(i) == '0') { //0's will contribute to the ans after flipping, so make them 1
                c[i] = 1;
                atLeastOneZero = true;
            } else { // 1's will not contribute to the ans after flipping, so make them -1
                c[i] = -1;
            }
        }

        if (!atLeastOneZero) {
            return new int[]{};
        }

        //After flipping, problem reduces to finding max sum subarray
        int[] ans = findMaxSumSubArray(c);
        return new int[]{ans[0] + 1, ans[1] + 1};
    }

    // Kadane's Algorithm (doesn't work if all are -ve numbers)
    private int[] findMaxSumSubArray(int[] A) {

        int maxSumSoFar = 0;
        int sum = 0;

        int start = 0;
        int end = A.length - 1;
        int s = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (maxSumSoFar < sum) {
                maxSumSoFar = sum;
                start = s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }
        return new int[]{start, end};
    }
}

