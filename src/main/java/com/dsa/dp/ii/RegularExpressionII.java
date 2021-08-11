package com.dsa.dp.ii;

public class RegularExpressionII {
    public int isMatch(final String A, final String B) {

        int n = A.length();
        int m = B.length();

        //dp[i][j] stores if A.subString(0,i) i.e (0 to i-1) is matched by B.subString(0,j) i.e (0 to j-1)
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true; //both empty means its a match

        for (int j = 1; j < m + 1; j++) {
            if (B.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; //ignore the *
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (B.charAt(j - 1) == '.' || (B.charAt(j - 1) == A.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1]; //check if matches till previous
                } else if (B.charAt(j - 1) == '*') {

                    dp[i][j] = dp[i][j - 2]; //ignore the *

                    // here * can not match any char, it can match only when taken in combination with preceding char
                    // i.e * and preceding char should be taken together
                    if (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }

                    // this is for the case when * can match anything
                    // dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; //ignore the * or match it till previous of A
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }
}
/*
Regular Expression II
Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Problem Constraints
1 <= length(A), length(B) <= 104



Input Format
The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.



Output Format
Return 1 if the patterns match else return 0.



Example Input
Input 1:

 A = "aab"
 B = "c*a*b"
Input 2:

 A = "acz"
 B = "a.a"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 So, return 1.
Explanation 2:

 '.' matches any single character. First two character in string A will be match.
 But the last character i.e 'z' != 'a'. Return 0.

 */