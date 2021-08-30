package com.dsa.sorting.i;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public int solve(int[] A) {
        Arrays.sort(A);//sorting makes minimum possible absolute difference occur between 2 consecutive elements
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, Math.abs(A[i] - A[i - 1]));
        }
        return min;
    }
}
