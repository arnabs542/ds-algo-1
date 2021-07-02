package com.dsa.arraysNmath;

import java.util.Arrays;

public class NextPermutation {

    public int[] nextPermutation(int[] A) {

        int val = A[A.length - 1];
        int idx = -1;

        // determining idx by iterating from last till a point where ascending order is broken
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < val) {
                idx = i;
                break;
            }
            val = A[i];
        }

        if (idx == -1) {
            Arrays.sort(A);
            return A;
        }

        int idx1 = -1;

        // iterate from last to determine next higher number for A[idx]
        for (int i = A.length - 1; i >= idx + 1; i--) {
            if (A[i] > A[idx]) {
                idx1 = i;
                break;
            }
        }

        //swap elements A[idx] and A[idx1]
        swap(A, idx, idx1);

        //sort from idx+1 till last
        //Arrays.sort(A,idx+1,A.length);

        //Actually sorting not needed as all are in descending order, just swap and make them in ascending order
        swapAll(A, idx + 1, A.length - 1);
        return A;
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    private void swapAll(int[] A, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(A, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}


/*
Problem Description

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format
The first and the only argument of input has an array of integers, A.



Output Format
Return an array of integers, representing the next permutation of the given array.



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
 */