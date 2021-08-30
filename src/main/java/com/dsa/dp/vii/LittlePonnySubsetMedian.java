package com.dsa.dp.vii;

public class LittlePonnySubsetMedian {
    public int solve(int[] A) {

        //refer notes for logic
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
