package com.dsa.sorting.ii;

import java.util.Arrays;

public class MaximumMinimumMagic {
    public int[] solve(int[] A) {

        int p = 1000000007;
        Arrays.sort(A);

        //after sorting, max possible subset difference will occur if we take diff of elements from the two divided subsets
        //after sorting, min possible subset difference will occur if we take diff of elements that are consecutive
        int start = 0;
        int mid = A.length / 2;

        int max = 0;
        int min = 0;

        int alt = 0;

        while (mid < A.length) {
            max = (max + Math.abs(A[mid++] - A[start++]) % p) % p;
            min = (min + Math.abs(A[alt + 1] - A[alt]) % p) % p;
            alt += 2;
        }
        return new int[]{max, min};
    }
}

