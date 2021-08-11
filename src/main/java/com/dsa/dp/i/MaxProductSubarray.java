package com.dsa.dp.i;

public class MaxProductSubarray {
    public int maxProduct(final int[] A) {

        int minSoFar = A[0];
        int maxSoFar = A[0];
        int ans = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) { //if current no. is negative, swap minSoFar and maxSoFar
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(A[i], maxSoFar * A[i]); //update maxSoFar
            minSoFar = Math.min(A[i], minSoFar * A[i]); //update minSoFar

            ans = Math.max(ans, maxSoFar);
        }
        return ans;
    }
}
/*
Max Product Subarray
Problem Description

Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.



Problem Constraints
1 <= N <= 5 * 105

-100 <= A[i] <= 100



Input Format
First and only argument is an integer array A.



Output Format
Return an integer corresponding to the maximum product possible.



Example Input
Input 1:

 A = [4, 2, -5, 1]
Input 2:

 A = [-3, 0, -5, 0]


Example Output
Output 1:

 8
Output 2:

 0


Example Explanation
Explanation 1:

 We can choose the subarray [4, 2] such that the maximum product is 8.
Explanation 2:

 0 will be the maximum product possible.

 */