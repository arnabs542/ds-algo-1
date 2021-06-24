package com.dsa.sorting.i;

public class InversionCountInArray {
    private int[] sortedArray;
    private long count = 0;
    private int mod = 1000000007;

    public int solve(int[] A) {
        sortedArray = new int[A.length];
        mergeSort(0, A.length - 1, A);
        return (int) count % mod;
    }

    private void mergeSort(int left, int right, int[] A) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) / 2);

        mergeSort(left, mid, A);
        mergeSort(mid + 1, right, A);
        merge(left, right, A);
    }

    private void merge(int left, int right, int[] A) {

        int aPtr = left;
        int mid = left + ((right - left) / 2);
        int bPtr = mid + 1;

        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && A[i] > A[j]) {
                j++;
            }
            count = (count + (j - (mid + 1L)) % mod) % mod;
        }

        int ansIdx = left;
        while (ansIdx <= right) {
            if ((aPtr <= mid) && (bPtr == right + 1 || A[aPtr] <= A[bPtr])) {
                sortedArray[ansIdx++] = A[aPtr++];
            } else if ((bPtr <= right) && (aPtr == mid + 1 || A[aPtr] > A[bPtr])) {
                sortedArray[ansIdx++] = A[bPtr++];
//                count = (count + (mid - aPtr + 1L) % mod) % mod; //all elements from aPtr till mid will all contribute to the answer
            }
        }
        //copy all elements of sortedArray back to original array, as it will be needed in subsequent recursions
        for (int i = left; i <= right; i++) {
            A[i] = sortedArray[i];
        }
    }
}
/*
Inversion count in an array
Problem Description

Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.

 */
