package com.dsa.tries;

public class MaximumXOR {

    public int solve(int[] A) {

        int ans = 0;

        TrieNode root = new TrieNode();
        insert(A[0], root);

        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, maxXor(root, A[i]));
            insert(A[i], root);
        }
        return ans;
    }

    private int maxXor(TrieNode root, int A) {
        TrieNode curr = root;
        int no = 0;

        //if bit is 1, to maximize XOR we need 0, so search if it exists else take whatever is there
        for (int j = 30; j >= 0; j--) {

            int bit = (A & (1 << j)) > 0 ? 1 : 0;

            if (bit == 0) {
                if (curr.children[1] != null) {
                    no += (int) Math.pow(2, j);
                    curr = curr.children[1];
                } else {
                    curr = curr.children[0];
                }
            } else {

                if (curr.children[0] != null) {
                    curr = curr.children[0];
                } else {
                    no += (int) Math.pow(2, j);
                    curr = curr.children[1];
                }
            }
        }
        return no ^ A;
    }

    // insert a number into trie
    private void insert(int N, TrieNode root) {

        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {

            int bit = ((N & (1 << i)) > 0) ? 1 : 0;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
    }

}
/*
Maximum XOR
Problem Description

Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.



Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return an integer denoting the maximum result of A[i] XOR A[j].



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 7
Output 2:

 117


Example Explanation
Explanation 1:

 Maximum XOR occurs between element of indices(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
Explanation 2:

 Maximum XOR occurs between element of indices(0-based) 1 and 2 i.e. 17 ^ 100 = 117.

 */