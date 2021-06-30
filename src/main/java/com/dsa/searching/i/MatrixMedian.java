package com.dsa.searching.i;

public class MatrixMedian {
    public int findMedian(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;
        int ans = -1;
        //binary search on [1, Integer.MAX_VALUE]
        int l = 1;
        int r = Integer.MAX_VALUE;

        int k = (rows * cols) / 2; //median is finding (k+1)th element
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            int lesser = lesserEqualCount(A, mid);

            if (lesser >= (k + 1)) {//can be median (when duplicates are present) or median is towards left
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    //total count of no.s <= mid in A
    private int lesserEqualCount(int[][] A, int mid) {
        int rows = A.length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            count += binarySearch(A[i], mid);
        }
        return count;
    }

    //returns the no. of elements in A s.t A[i] <= elem
    private int binarySearch(int[] A, int elem) {
        int l = 0;
        int r = A.length - 1;

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (A[mid] <= elem) {
                l = mid + 1;
                ans = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
/*
Matrix Median
Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of the matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of the matrix A.



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5
Output 2:

 17


Example Explanation
Explanation 1:


A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.
Explanation 2:


Median is 17.

 */
