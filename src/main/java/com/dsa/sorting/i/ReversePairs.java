package com.dsa.sorting.i;

public class ReversePairs {
    private int[] sortedArray;
    private int count = 0;

    public int solve(int[] A) {
        sortedArray = new int[A.length];
        mergeSort(0, A.length - 1, A);

        return count;
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

        //for every element in 1st half that satisfies, determine no. of elements in 2nd half
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && A[i] / 2.0 > A[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int ansIdx = left;
        while (ansIdx <= right) {
            if ((aPtr <= mid) && (bPtr == right + 1 || A[aPtr] <= A[bPtr])) {
                sortedArray[ansIdx++] = A[aPtr++];
            } else if ((bPtr <= right) && (aPtr == mid + 1 || A[aPtr] > A[bPtr])) {
                sortedArray[ansIdx++] = A[bPtr++];
            }
        }
        //copy all elements of sortedArray back to original array, as it will be needed in subsequent recursions
        for (int i = left; i <= right; i++) {
            A[i] = sortedArray[i];
        }
    }
}
/*
Reverse pairs
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).

 */
