package com.dsa.arraysNmath;

public class Carotenemia {

    public int solve(int[] A, int B) {

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= B) {
                return i;
            }
        }
        return -1;
    }
}

