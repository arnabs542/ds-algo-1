package com.dsa.greedy.i;

import java.util.Arrays;

public class AssignMiceToHoles {
    public int mice(int[] A, int[] B) {

        // first rat going to first hole will lead to shortest time, so sort
        Arrays.sort(A);
        Arrays.sort(B);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, Math.abs(A[i] - B[i]));
        }
        return max; //max time taken by some rat
    }
}


