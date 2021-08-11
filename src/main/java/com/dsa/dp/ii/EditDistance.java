package com.dsa.dp.ii;

public class EditDistance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();

        //dp[i][j] stores minimum steps required to make A.subString(0,i) i.e (0 to i-1) equal to B.subString(0,j) i.e (0 to j-1)
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) //if one string is empty, minSteps = length of other string
            dp[i][0] = i;
        for (int j = 0; j < m + 1; j++)
            dp[0][j] = j;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { //if chars are same, minSteps is same as dp[i - 1][j - 1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1; //get min from inserted, replace, delete
                }
            }
        }
        return dp[n][m];
    }
}
/*
Edit Distance
Problem Description

Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints
1 <= length(A), length(B) <= 450



Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.



Output Format
Return an integer, representing the minimum number of steps required.



Example Input
Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.

Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.

 */
