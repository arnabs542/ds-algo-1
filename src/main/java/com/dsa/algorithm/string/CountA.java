package com.dsa.algorithm.string;

public class CountA {
    public int solve(String A) {

        int count = 0; //no. of a's
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                count++;
            }
        }
        return count * (count + 1) / 2; //no. of ways of choosing 2 boundaries around n elements (n+1)C2
    }
}
/*
Count A
Problem Description

You are given a string A. Find the number of substrings that start and end with 'a'.



Problem Constraints
1 <= |A| <= 105

String will have only lowercase English letters.



Input Format
Given the only argument is a String A.



Output Format
Return number of substrings that start and end with 'a'.



Example Input
Input 1:

 A = "aab"
Input 2:

 A = "bcbc"


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings that start and end with 'a' are:
    1. "a"
    2. "aa"
    3. "a"
Explanation 2:

 There are no substrings that start and end with 'a'.

 */