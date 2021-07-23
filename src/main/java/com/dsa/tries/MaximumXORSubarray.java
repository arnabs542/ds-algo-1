package com.dsa.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaximumXORSubarray {

    public int[] solve(int[] A) {

        TrieNode root = new TrieNode();
        insert(0, root);

        //store array values with indices in a map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(0)));

        int currPrefixXOR = 0;
        int maxXor = 0;

        int[] ans = new int[2];

        for (int i = 0; i < A.length; i++) {
            currPrefixXOR ^= A[i];

            ArrayList<Integer> values = map.getOrDefault(currPrefixXOR, new ArrayList<>());
            values.add(i + 1);
            map.put(currPrefixXOR, values);

            int currMaxXor = maxXor(root, currPrefixXOR);

            //get all indices of 'no' that gives maxXor for A[i]
            ArrayList<Integer> indices = map.getOrDefault(currMaxXor ^ currPrefixXOR, new ArrayList<>());

            int minDiff = Integer.MAX_VALUE; //min difference between 'no's index and i
            int k = 0; //start index

            for (Integer index : indices) {
                if (Math.abs(i + 1 - index) < minDiff && index < (i + 1)) {//choose index < i and that gives min. diff w.r.t i
                    minDiff = Math.abs(i + 1 - index);
                    k = index;
                }
            }

            //if greater, simply update
            if (currMaxXor > maxXor) {
                maxXor = currMaxXor;
                ans[0] = k;
                ans[1] = i + 1;
            } else if (currMaxXor == maxXor) {//if equal, satisfy constraints in the question
                if ((i + 1 - k < ans[1] - ans[0]) || (i + 1 - k == ans[1] - ans[0] && k < ans[0])) {
                    ans[0] = k;
                    ans[1] = i + 1;
                }
            }

            insert(currPrefixXOR, root);
        }

        return new int[]{ans[0] + 1, ans[1]};
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
Maximum XOR Subarray
Problem Description

Given an array A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N which has maximum XOR value.

NOTE: If there are multiple subarrays with same maximum value, return the subarray with minimum length. If length is same, return the subarray with minimum starting index.



Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.



Example Input
Input 1:

 A = [1, 4, 3]
Input 2:

 A = [8]


Example Output
Output 1:

 [2, 3]
Output 2:

 [1, 1]


Example Explanation
Explanation 1:

 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].
Explanation 2:

 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].

 */