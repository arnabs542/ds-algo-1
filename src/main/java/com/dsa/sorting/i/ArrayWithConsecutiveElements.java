package com.dsa.sorting.i;

import java.util.Arrays;

public class ArrayWithConsecutiveElements {

    public int solve(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] != 1) {//after sorting elements will be consecutive, if not return 0
                return 0;
            }
        }
        return 1;
    }
}

