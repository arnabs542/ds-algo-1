package com.dsa.sorting.i;

public class MaximumUnsortedSubarray {
    public int[] subUnsort(int[] A) {

        int leftIndex = -1;//index (including) till which array is sorted i.e from start -> leftIndex
        int rightIndex = -1;//index (including) till which array is sorted i.e from rightIndex -> last

        boolean flag = false;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, A[i]);
            }
        }

        flag = false;

        int max = Integer.MIN_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, A[i]);
            }
        }

        //need to start sorting from index whose value > min
        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                leftIndex = i;
                break;
            }
        }

        //need to end sorting at index whose value < max
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < max) {
                rightIndex = i;
                break;
            }
        }

        if (rightIndex - leftIndex <= 0) {
            return new int[]{-1};
        }
        return new int[]{leftIndex, rightIndex};
    }
}
/*
Maximum Unsorted Subarray
Problem Description

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000



Input Format
First and only argument is an array of non-negative integers of size N.



Output Format
Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.



Example Input
Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output
Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation
Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.
 */