package com.dsa.twoPointers;

import java.util.HashSet;

public class CountSubarrays {
    public int solve(int[] A) {

        int mod = 1000000007;
        long ans = 0L;
        HashSet<Integer> set = new HashSet<>();

        int j = 0; //left pointer of sliding window
        int i = 0; //right pointer of sliding window
        for (; i < A.length; i++) {

            if (set.contains(A[i])) {
                while (set.contains(A[i])) { //shrink window from left till duplicates are removed
                    set.remove(A[j]);
                    j++;
                }
            }
            set.add(A[i]);
            ans = (ans + i - j + 1) % mod; //no. of subarrays ending at ith index
        }
        return (int) (ans % mod);
    }
}

