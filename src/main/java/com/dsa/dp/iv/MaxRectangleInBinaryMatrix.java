package com.dsa.dp.iv;

public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        //change 0's to some big value,  to distinguish between consecutive 1's and 0's so that kadane's works fine
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = -1000;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {//fix top row

            //clubs all column values into one for all rows, arr[0] will have 0th column values for all rows from i to j
            int[] arr = new int[m];
            for (int j = i; j < n; j++) {//fix bottom row

                for (int k = 0; k < m; k++) {
                    arr[k] += A[j][k];
                }

                int[] indices = maxSubArraySum(arr); //kadane on arr

                if (indices[1] < 0 || indices[0] < 0) { //skip if all negative no.s in arr
                    continue;
                }
                ans = Math.max(ans, (indices[1] - indices[0] + 1) * (j - i + 1));
            }
        }
        return ans;
    }

    //kadane's algorithm
    //returns {-1,-1} for all negative numbers
    private int[] maxSubArraySum(int[] A) {

        int start = -1;
        int end = -1;
        int s = 0;

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < A.length; i++) { //iterate all rows
            maxEndingHere += A[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            }
        }
        return new int[]{start, end};
    }
}
/*
Max Rectangle in Binary Matrix
Problem Description

Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing all ones and return its area.



Problem Constraints
1 <= N, M <= 100



Input Format
First argument is an 2-D binary array A.



Output Format
Return an integer denoting the area of largest rectangle containing all ones.



Example Input
Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ]


Example Output
Output 1:

 4
Output 2:

 3


Example Explanation
Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1,0), (1,1) and (1,2).
 */
