package com.dsa.searching.i;

public class RotatedSortedArraySearch {
    public int search(final int[] A, int B) {

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {

            // to avoid duplicates
            while (l < r && A[l] == A[l + 1]) {
                l++;
            }
            while (l < r && A[r] == A[r - 1]) {
                r--;
            }

            int mid = l + (r - l) / 2;

            if (A[mid] == B) {
                return mid;
            }
            if (A[mid] >= A[l]) {
                if (A[mid] > B && A[l] <= B) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[mid] < B && A[r] >= B) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

        //rotated array -> 4,5,6,1,2,3 pivoted at index 3
        //sorted array -> 1,2,3,4,5,6
//        int pivotIndex = findPivotIndex(A);
//
//        // System.out.println("DSFSD " + pivotIndex);
//        int l = 0;
//        int r = A.length - 1;
//
//        while (l <= r) {
//
//            int mid = l + ((r - l) / 2);
//            //mid of rotated array is translated into its corresponding position in sorted array
//            int newMid = (mid + pivotIndex) % (A.length); //this is done to apply binary search on sorted array instead of rotated array
//
//            if (A[newMid] > B) {
//                r = mid - 1;
//            } else if (A[newMid] < B) {
//                l = mid + 1;
//            } else {
//                return newMid;
//            }
//        }
//        return -1;
    }

    //Binary search to find pivot index
    private int findPivotIndex(int[] A) {
        int l = 0;
        int r = A.length - 1;

        int pivot = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (A[mid] >= A[0]) { //if >= first element pivot will be in right half
                l = mid + 1;
            } else if (A[mid] < A[0]) { // if < first element, this can be the pivot or will be in left half
                pivot = mid;
                r = mid - 1;
            }
//            if (A[mid] > A[A.length - 1]) { //if > last element pivot will be in right half
//                l = mid + 1;
//            } else if (A[mid] <= A[A.length - 1]) { // if <= last element, this can be the pivot or will be in left half
//                pivot = mid;
//                r = mid - 1;
//            }
        }
        return pivot;
    }
}
/*
Rotated Sorted Array Search
Problem Description

Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a B value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are disitinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A = [1]
B = 1


Example Output
Output 1:

 0
Output 2:

 0


Example Explanation
Explanation 1:


Target 4 is found at index 0 in A.
Explanation 2:


Target 1 is found at index 0 in A.
 */
