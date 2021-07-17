package com.dsa.maths.ii;

import java.util.ArrayList;
import java.util.List;

public class SortedPermutationRankWithRepeats {

    private int p = 1000003;
    private long[] fact;
    private int[] ranks = new int[256];

    public int findRank(String A) {

        int length = A.length();
        constructFactorialArray(length);

        //ranks array stores the no. of occurences of the char at its ascii value index
        for (int i = 0; i < length; i++) {
            ranks[A.charAt(i)]++;
        }

        long noOfPermutations = 0;
        //traverse the input string
        for (int i = 0; i < length; i++) {

            //for every character in the input string, check how many permutations are possible and add them up to sum
            for (Character c : distinctCharsBefore(A.charAt(i))) {
                long count = (fact[length - i - 1] * getInverseModOfDenom(c)) % p; //length-i-1 is the no. of characters that can be permuted
                noOfPermutations = (noOfPermutations % p + count) % p;
            }
            ranks[A.charAt(i)]--; //update ranks array as all permutations that occur before this char has been calculated
        }
        return (int) (noOfPermutations + 1) % p;
    }

    //returns the denominator (mod applied)
    private long getInverseModOfDenom(char c) {
        long prod = 1L;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] > 1) {
                prod = (i == (int) c) ? ((prod % p) * fact[ranks[i] - 1]) % p : ((prod % p) * fact[ranks[i]]) % p;
            }
        }
        return inverseMod(prod, p);
    }

    //returns all distinct chars that occur before character 'c'
    private List<Character> distinctCharsBefore(char c) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < (int) c; i++)
            if (ranks[i] > 0)
                chars.add((char) i);
        return chars;
    }

    private void constructFactorialArray(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % p;
    }

    private long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p);
        } else {
            return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
        }
    }

    // a^(p-1) mod p = 1 mod p
    // => a^(p-2) mod p = a^(-1) mod p
    private long inverseMod(long a, int p) {
        return power(a, p - 2, p);
    }
}
/*
Sorted Permutation Rank with Repeats
Problem Description

Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.

NOTE:

The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
String A can consist of both lowercase and uppercase letters. Characters with lesser ascii value are considered smaller i.e. 'a' > 'Z'.


Problem Constraints
1 <= len(A) <= 1000000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank.



Example Input
Input 1:

 A = "aba"
Input 2:

 A = "bca"


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 The order permutations with letters 'a', 'a', and 'b' :
    aab
    aba
    baa
 So, the rank is 2.
Explanation 2:

 The order permutations with letters 'a', 'b', and 'c' :
    abc
    acb
    bac
    bca
    cab
    cba
 So, the rank is 4.

 */
