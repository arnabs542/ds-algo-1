package com.dsa.searching.i;

public class SpecialInteger {
    public int solve(int[] A, int B) {

        int l = 1;
        int r = A.length;

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (ifEachSumLessThanEqualsB(A, B, mid)) {//mid is window size, if each sum not greater then increase window size
                ans = mid;//this can be ans, but keep checking for higher value
                l = mid + 1;
            } else {//decrease window size
                r = mid - 1;
            }
        }
        return ans;
    }

    //checks all subarrays of size k and returns false if any subarray sum is greater than B
    private boolean ifEachSumLessThanEqualsB(int[] A, int B, int k) {

        long sum = 0L;
        for (int i = 0; i < k; i++) {
            sum += A[i];
        }
        if (sum > B) {
            return false;
        }
        for (int i = 0, j = k; j < A.length; i++, j++) {
            sum -= A[i];
            sum += A[j];

            if (sum > B) {
                return false;
            }
        }
        return true;
    }
}
/*
Special Integer
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3.

 */
