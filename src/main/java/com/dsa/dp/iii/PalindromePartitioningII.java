package com.dsa.dp.iii;

import java.util.Arrays;

public class PalindromePartitioningII {
    public int minCut(String A) {

        int n = A.length();

        boolean[][] pal = new boolean[n][n]; //pal[i][j] stores whether A.subString(i,j+1) is palindrome

        for (int i = 0; i < n; i++)
            pal[i][i] = true; //single char is a palindrome

        for (int i = 0; i < n - 1; i++) //check for strings of length 2
            if (A.charAt(i) == A.charAt(i + 1))
                pal[i][i + 1] = true;

        for (int len = 3; len <= n; len++) {//for each length
            for (int i = 0; i + len - 1 < n; i++) { //fix i
                int j = i + len - 1; //fix j
                if (A.charAt(i) == A.charAt(j))
                    pal[i][j] = pal[i + 1][j - 1];
            }
        }

        int[] dp = new int[n]; //dp[i] stores min. # of partitions of A.subString(i, end)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0; //no need of partitions for last char, as each char itself is palindrome

        for (int i = n - 2; i >= 0; i--) { //iterate from last
            if (pal[i][n - 1]) { //if palindrome, no need to partition
                dp[i] = 0;
            } else {
                for (int k = i; k < n - 1; k++) //place partition at each possible position between i and n-2 and determine min
                    if (pal[i][k]) //place partition after k
                        dp[i] = Math.min(dp[i], 1 + dp[k + 1]);
            }
        }
        return dp[0];
    }
}