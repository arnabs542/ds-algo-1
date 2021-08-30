package com.dsa.maths.iii;

public class ComputeNcRModM {

    public int solve(int n, int r, int m) {
        int[] pascal = new int[r + 1];
        pascal[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                pascal[j] = (pascal[j] + pascal[j - 1]) % m;
            }
        }
        return pascal[r];
    }
}

