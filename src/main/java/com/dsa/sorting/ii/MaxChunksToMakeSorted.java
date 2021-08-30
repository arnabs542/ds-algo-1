package com.dsa.sorting.ii;

public class MaxChunksToMakeSorted {

    public int solve(int[] A) {

        int ans = 0;
        int max = -1;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max == i) { //if max elem till i equals i, we can create a chunk
                ans++;
            }
        }
        return ans;
    }
}

