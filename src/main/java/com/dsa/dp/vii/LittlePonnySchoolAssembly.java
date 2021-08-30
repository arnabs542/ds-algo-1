package com.dsa.dp.vii;

import java.util.Arrays;

public class LittlePonnySchoolAssembly {

    private final int[] globalA = new int[4];
    private final int mod = 1000000007;

    private long[][][][] dp;

    public int solve(int[] A) {

        globalA[0] = A[0];
        globalA[1] = A[1];
        globalA[2] = A[2];
        globalA[3] = A[3];

        dp = new long[A[0] + 1][A[1] + 1][A[2] + 1][A[3] + 1];

        //initialize dp with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    Arrays.fill(dp[i][j][k], -1L);
                }
            }
        }
        return (int) recurse(A[0], A[1], 0, 0);
    }

    private long recurse(int boysRem, int girlsRem, int prevConsecBoys, int prevConsecGirls) {

        if (boysRem == 0 && girlsRem == 0) { //arranged everyone, so return 1
            return 1;
        }

        //use memoized result
        if (dp[boysRem][girlsRem][prevConsecBoys][prevConsecGirls] != -1L) {
            return dp[boysRem][girlsRem][prevConsecBoys][prevConsecGirls];
        }

        long temp = 0L;
        //choose a boy
        if (prevConsecBoys < globalA[2] && boysRem > 0) {
            temp = recurse(boysRem - 1, girlsRem, prevConsecBoys + 1, 0);
        }

        //choose a girl
        if (prevConsecGirls < globalA[3] && girlsRem > 0) {
            temp = (temp + recurse(boysRem, girlsRem - 1, 0, prevConsecGirls + 1)) % mod;
        }

        dp[boysRem][girlsRem][prevConsecBoys][prevConsecGirls] = temp;
        return temp;
    }
}

