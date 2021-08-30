package com.dsa.hashing.i;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i] - 1)) {//can be start of sequence, so calculate length of possible sequence
                int j = 1;
                while (set.contains(A[i] + j)) {//if we find consecutive no. then check next consecutive
                    j++;
                }
                ans = Math.max(ans, j);
            }
        }
        return ans;
    }
}

