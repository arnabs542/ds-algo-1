package com.dsa.dp.ii;

import java.util.Arrays;

public class OddPalindrome {
    public int[] solve(String A) {

        int mod = 1000000007;
        //very difficult question
        //refer class notes for visualisation and approach
        String B = (new StringBuilder(A)).reverse().toString();
        int n = A.length();

        //dp[i][j] stores no. of common subsequences in A.subString(0,i) i.e (0 to i-1) and B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 1); // common subsequences between "" & "anyChar" = 1
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1]) % mod - dp[i - 1][j - 1] + mod) % mod;

                if (A.charAt(i - 1) == B.charAt(j - 1)) { //if chars are same
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (dp[i][n - i - 1]) % mod;
        }
        return ans;
    }
}
/*
Odd Palindrome
Problem Description

A palindrome string is a string which reads the same forward and backward. If a palindrome string is of odd length l, then (l+1)/2th character (1 index based) is said to be the centre of the palindrome.

You are given a string A. Return an array X of integers where X[i] = (number of odd length palindrome subsequence of A with A[i] as the centre) modulo (109 + 7).

A subsequence of A is a string which can be derived from A by deleting some of its character.



Problem Constraints
1 <= length(A) <= 1000
Every character of A will be a lowercase English letter 'a' - 'z'.



Input Format
First and only argument is a string A.



Output Format
Return an integer array X as mentioned in the question.



Example Input
Input 1:

 A = "xyzx"
Input 2:

 A = "ababzz"


Example Output
Output 1:

 [1, 2, 2, 1]
Output 2:

 [1, 2, 2, 1, 1, 1]


Example Explanation
Explanation 1:


 Index(i)  |   Palindrome subsequences with centre i
   0       |   a
   1       |   y, xyx
   2       |   z, xzx
   3       |   x
 So, output array is [1, 2, 2, 1]

Explanation 2:

 Index(i)  |  Palindrome subsequences with centre i
   0       |  a
   1       |  b, aba
   2       |  a, bab
   3       |  b
   4       |  z
   5       |  z
 So, output array is [1, 2, 2, 1, 1, 1]

 */
