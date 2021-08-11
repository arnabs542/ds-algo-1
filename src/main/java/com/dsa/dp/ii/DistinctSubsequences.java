package com.dsa.dp.ii;

public class DistinctSubsequences {
    public int numDistinct(String A, String B) {

        int n = A.length();
        int m = B.length();

        //dp[i][j] stores distinct subsequences of A.subString(0,i) i.e (0 to i-1) that equals B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) { //if B is empty, in one way we can form subsequence to match "", i.e by not considering anything in A
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (A.charAt(i - 1) != B.charAt(j - 1)) { //if chars are not same, consider previous value itself
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; //if chars are same
                }
            }
        }
        return dp[n][m];
    }
}
/*
Distinct Subsequences
Problem Description

Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



Problem Constraints
1 <= length(A), length(B) <= 700



Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format
Return an integer representing the answer as described in the problem statement.



Example Input
Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit"
 B = "rabbit"


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit"
    => A = "rab_bit"
    => A = "rabb_it"

 Note: "_" marks the removed character.

 */