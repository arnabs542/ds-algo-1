package com.dsa.searching.i;

public class SingleElementInSortedArray {

    public int solve(int[] A) {

        //ans will always be at even index
        // arr -> 1 1 2 2 3 3 4 4 5 6 6  7  7  8  8
        // idx -> 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        int l = 0;
        int r = A.length - 1;

        int ans = 0;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            //even
            if (mid % 2 == 0) {
                if (mid != 0 && A[mid] == A[mid - 1]) {// mid != 0 to handle corner case,  can't go beyond 0 to the left
                    r = mid - 1; //take above example, it will be clear
                } else {
                    ans = mid;
                    l = mid + 1;
                }
            } else {//odd
                if (A[mid] == A[mid + 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return A[ans];
    }
}
/*
Single Element in a Sorted Array
Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once

 */