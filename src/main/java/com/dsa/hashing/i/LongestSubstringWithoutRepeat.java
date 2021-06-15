package com.dsa.hashing.i;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {

        int[] countOfChars = new int[256]; //store count of each character so far
        int maxSoFar = 0; //length of longest substring so far

        int j = 0; //left pointer
        for (int i = 0; i < A.length(); i++) {
            countOfChars[A.charAt(i)]++;

            while (countOfChars[A.charAt(i)] > 1) {
                countOfChars[A.charAt(j)]--;
                j++; //if substring between j and i+1 does not have distinct chars, increment left pointer
            }   
            maxSoFar = Math.max(maxSoFar, i - j + 1);
        }
        return maxSoFar;
    }
}
/*
Longest Substring Without Repeat
Problem Description

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.

 */