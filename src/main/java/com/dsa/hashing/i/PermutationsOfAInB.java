package com.dsa.hashing.i;

public class PermutationsOfAInB {
    public int solve(String A, String B) {

        if (A.length() > B.length()) {
            return 0;
        }
        int[] countA = new int[26];
        int[] countB = new int[26];

        //count of chars in A
        for (int i = 0; i < A.length(); i++) {
            countA[A.charAt(i) - 'a']++;
        }
        //count of chars in B in first window of size A.length()
        for (int i = 0; i < A.length(); i++) {
            countB[B.charAt(i) - 'a']++;
        }

        int ans = checkIfSubstringIsPermutation(countA, countB); //check first window

        //check each count sized window, if its a permutation
        for (int i = 0, j = A.length(); j < B.length(); i++, j++) {
            countB[B.charAt(j) - 'a']++; //new character coming in at j
            countB[B.charAt(i) - 'a']--; //prev character moving out from window

            ans += checkIfSubstringIsPermutation(countA, countB); //current window starts at i+1
        }
        return ans;
    }

    //returns 1 if substring is a permutation
    private int checkIfSubstringIsPermutation(int[] countA, int[] countB) {
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                return 0;
            }
        }
        return 1;
    }
}
/*
Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa

 */