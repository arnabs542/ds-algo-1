package com.dsa.twoPointers;

public class CountPairsWithSum {
    public int solve(int[] A, int B) {

        int l = 0;
        int r = A.length - 1;

        int ans = 0;
        //basic two pointer approach
        while (l < r) {
            if (A[l] + A[r] > B) {
                r--;
            } else if (A[l] + A[r] < B) {
                l++;
            } else {
                ans++;
                l++;
            }
        }
        return ans;
    }
}

