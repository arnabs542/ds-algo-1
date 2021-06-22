package com.dsa.twoPointers;

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

        int countofZeros = 0; //no. of zeros in the sliding window
        int maxSoFar = 0; //length of the largest sequence so far

        int start = -1; //index where the largest sequence starts
        int end = -1; //index where the largest sequence ends

        int j = 0; //left pointer of sliding window
        for (int i = 0; i < A.size(); i++) { //i is the right pointer of sliding window
            if (A.get(i) == 0) {
                countofZeros++;
            }
            while (countofZeros > B) {
                if (A.get(j) == 0) {
                    countofZeros--;
                }
                j++; //move left pointer towards right till countOfZeroes is not greater than B
            }
            if (maxSoFar < i - j + 1) { // update sliding window size and start/end indices
                maxSoFar = Math.max(maxSoFar, i - j + 1);
                end = i;
                start = j;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ans.add(i);
        }
        return ans;
    }
}
/*
Max Continuous Series of 1s
Problem Description

Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

For this problem, return the indices of maximum continuous series of 1s in order.

If there are multiple possible solutions, return the sequence which has the minimum start index.



Problem Constraints
0 <= B <= 105

1 <= size(A) <= 105

A[i]==0 or A[i]==1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.



Example Input
Input 1:

 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1
Input 2:

 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 [0, 1, 2, 3, 4]
Output 2:

 [3, 4, 5, 6]


Example Explanation
Explanation 1:

 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
Explanation 2:

 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].

 */