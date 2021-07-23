package com.dsa.tries;

public class SubarraysXorLessThanB {

    private int ans = 0;
    private int mod = 1000000007;

    public int solve(int[] A, int B) {
        if (A.length == 1) {
            return A[0] >= B ? 0 : 1;
        }

        TrieNode root = new TrieNode();
        insert(0, root); //initialize trie with 0
        int prefixXOR = 0;

        for (int i = 0; i < A.length; i++) {
            prefixXOR ^= A[i];
            query(root, prefixXOR, B);
            insert(prefixXOR, root);
        }
        return (ans % mod);
    }

    private void query(TrieNode root, int prefixXOR, int B) {

        TrieNode curr = root;

        for (int i = 30; i >= 0 && curr != null; i--) {
            int bBit = (B & (1 << i)) > 0 ? 1 : 0;
            int prefixBit = (prefixXOR & (1 << i)) > 0 ? 1 : 0;

            if (bBit == 0) { // p^x = 0 means p and x have same bits, so whatever bit we had in prefixBit we want same
                curr = curr.children[prefixBit];
            } else { // p^x = 1 means p and x have diff bits, so we want opposite bit to prefixBit
                ans = (ans + (curr.children[prefixBit] != null ? curr.children[prefixBit].freq : 0)) % mod;
                curr = curr.children[1 - prefixBit];
            }
        }
    }

    // insert a number into trie
    private void insert(int N, TrieNode root) {

        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = ((N & (1 << i)) > 0) ? 1 : 0;

            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            } else {
                curr.children[bit].freq++;
            }
            curr = curr.children[bit];
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
        int freq = 1;
    }
}

/*
Subarrays Xor Less Than B
Problem Description

Given an array of integers A. Find and return the number of subarrays whose xor values is less than B.
NOTE: As the answer can be very large, return the answer modulo (109+7).



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 105
1 <= B <= 106



Input Format
The argument given is the integer array A
Second argument is an integer B.



Output Format
Return an integer denoting the number of subarrays whose xor values is less than B.



Example Input
Input 1:

 A = [8, 3, 10, 2, 6, 7, 6, 9, 3]
 B = 3
Input 2:

 A = [9, 4, 3, 11]
 B = 7


Example Output
Output 1:
 5
Output 2:

 3


Example Explanation
Explanation 1:

 Generate all the subarrays and their corresponding xor and there are only 5 such subaraays which have xor less than 3.
Explanation 2:

 Subarrays with xor < 7 are : [9, 4, 3, 11], [4] and [3].
 So, the answer is 3.

 */