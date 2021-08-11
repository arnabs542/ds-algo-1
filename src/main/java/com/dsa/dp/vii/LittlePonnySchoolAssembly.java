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
/*
Little Ponny and School Assembly
Problem Description

You are given B boys and G girls.

You want to arrange them to form a school assembly such that no more than C boys and no more thanD girls are standing together.

Two arrangements are different if there exists one position such that there is a girl at this position in one of them and a boy in another.

Since, the result can be large, print it modulo 109 + 7



Problem Constraints
1 <= B, G <= 100

1 <= C, D <= 10



Input Format
The argument of the input is the array A containing 4 elements representing the value of B, G, C and D respectively.



Output Format
Return an integer representing the answer



Example Input
Input 1:

A: [2, 1, 1, 10]
Input 2:

A: [2, 3, 1, 2]
Input 3:

A: [2, 4, 1, 1]


Example Output
Output 1:

1
Output 2:

5
Output 3:

0


Example Explanation
Explanation 1:

In this example the only possible assembly is: BGB
Explanation 2:

In this example 5 possible assembly exist:

BGBGG
BGGBG
GBGBG
GBGGB
GGBGB
Explanation 3:

There is no possible arrangement for this example

 */
