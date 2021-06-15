package com.dsa.hashing.i;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i] - 1)) {//can be start of sequence, so calculate length of possible sequence
                int j = 1;
                while (set.contains(A[i] + j)) {//if we find consecutive no. then check next consecutive
                    j++;
                }
                ans = Math.max(ans, j);
            }
        }
        return ans;
    }
}
/*
Longest Consecutive Sequence
Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].
 */
