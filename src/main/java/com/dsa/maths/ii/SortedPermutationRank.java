package com.dsa.maths.ii;

public class SortedPermutationRank {

    private int p = 1000003;
    private long[] fact;
    private int[] ranks = new int[256];

    public int findRank(String A) {

        int length = A.length();
        constructFactorialArray(length);// store factorials of all numbers from 1 to length (mod applied)

        //mark 1 at the index which is ascii value of the char, indicating presence of that char
        for (int i = 0; i < length; i++)
            ranks[A.charAt(i)] = 1;

        //this operation will store rank of each character in the ranks array itself
        for (int i = 1; i < ranks.length; i++)
            ranks[i] += ranks[i - 1];

        long ans = 0;

        for (int i = 0; i < length; i++) {
            ans += ((ranks[A.charAt(i)] - 1) * fact[length - i - 1]) % p; // no. of chars before char at i = (rankOfCharAti - 1)
            updateRanks(A.charAt(i)); //since char is used up, update ranks
        }

        return (int) (ans + 1) % p;
    }

    private void constructFactorialArray(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % p;
    }

    private void updateRanks(char c) {
        for (int i = c + 1; i < ranks.length; i++)
            ranks[i]--; //reduce rank of all chars that are after char c
    }
}
/*
Sorted Permutation Rank
Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank of the given string.



Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:

2
Output 2:

1


Example Explanation
Explanation 1:

Given A = "acd".
The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.

 */