package com.dsa.graphs.iii;

import java.util.Arrays;

public class SheldonAndPairOfCities {

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {

        //Floyd Warshall application
        int[][] dp = new int[A + 1][A + 1];
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < A + 1; i++) {
            dp[i][i] = 0;
        }

        //multiple roads exist, so take min out of all
        for (int i = 0; i < B; i++) {
            dp[D[i]][E[i]] = Math.min(F[i], dp[D[i]][E[i]]);
            dp[E[i]][D[i]] = Math.min(F[i], dp[D[i]][E[i]]);
        }

        //refer class notes for algo explanation, Floyd Warshall algo
        for (int k = 1; k < A + 1; k++) {
            for (int i = 1; i < A + 1; i++) {
                for (int j = 1; j < A + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int[] ans = new int[C];
        for (int i = 0; i < C; i++) {
            ans[i] = Math.min(dp[G[i]][H[i]], dp[H[i]][G[i]]); //take shortest path between two cities (out of both directions)
            if (ans[i] == Integer.MAX_VALUE / 2) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}

