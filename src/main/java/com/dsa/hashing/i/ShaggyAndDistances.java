package com.dsa.hashing.i;

import java.util.HashMap;

public class ShaggyAndDistances {

    public int solve(int[] A) {

        int ans = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int prevIndex = map.get(A[i]);
                ans = Math.min(ans, Math.abs(i - prevIndex)); //if no. already existed, calculate i-j and compare with previous ans
            }
            map.put(A[i], i); //update latest occurrence of the no.
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

