package com.dsa.arrays;

public class SpecialSubsequencesAG {
    public int solve(String A) {

        char[] c = A.toCharArray();

        int noOfAs = 0;
        int count = 0;

        // first count no. of A's till a G is encountered
        // once G is encountered, total possible AG subsequences will be no. of A's till that G, so add no. of A's to the answer
        // repeat above steps
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'A') {
                noOfAs++;
            } else if (c[i] == 'G') {
                count += noOfAs;
            }
        }
        return count;
    }
}
/*
Special Subsequences "AG"
Problem Description

You have given a string A having Uppercase English letters.

You have to find that how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints
1 <= length(A) <= 105



Input Format
First and only argument is a string A.



Output Format
Return an integer denoting the answer.



Example Input
Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 Subsequence "AG" is 3 times in given string
Explanation 2:

 There is no subsequence "AG" in the given string.

 */