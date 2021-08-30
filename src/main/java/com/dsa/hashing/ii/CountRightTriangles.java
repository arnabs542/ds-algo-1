package com.dsa.hashing.ii;

import java.util.HashMap;

public class CountRightTriangles {
    public int solve(int[] A, int[] B) {

        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            mapX.put(A[i], mapX.getOrDefault(A[i], 0) + 1); //for each co-ordinate, count no. of points with same X co-ordinate
            mapY.put(B[i], mapY.getOrDefault(B[i], 0) + 1); //for each co-ordinate, count no. of points with same Y co-ordinate
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += (mapX.get(A[i]) - 1) * (mapY.get(B[i]) - 1); // -1 because need to exclude point at which right angle is formed
        }
        return ans;
    }
}

