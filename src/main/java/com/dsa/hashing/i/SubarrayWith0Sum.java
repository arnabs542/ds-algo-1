package com.dsa.hashing.i;

import java.util.HashSet;

public class SubarrayWith0Sum {
    public int solve(int[] A) {

        HashSet<Long> set = new HashSet<>();//contains prefixSums
        // add 0 initially because we may get currentSum as 0 at any point for which we need to return true
        // or else add another condition  if (set.contains(currentSum) || currentSum == 0)
        // set.add(0L);

        long currentSum = 0L;
        for (int i = 0; i < A.length; i++) {
            currentSum += Long.valueOf(A[i]);

            if (set.contains(currentSum) || currentSum == 0) {// if currentSum already exists, then there is a subarray with sum 0
                return 1;
            } else {
                set.add(currentSum);
            }
        }
        return 0;
    }
}
