package com.dsa.sorting.i;

public class AlternatePositiveNegativeElements {
    public int[] solve(int[] A) {

        int j;
        for (int i = 0; i < A.length; i++) {
            j = i;
            if ((i % 2 == 0) && A[i] >= 0) {
                while (j < A.length && A[j] >= 0) {
                    j++;
                }
                rotateRight(i, j, A);
            } else if ((i % 2 == 1) && A[i] < 0) {
                while (j < A.length && A[j] < 0) {
                    j++;
                }
                rotateRight(i, j, A);
            }
        }
        return A;
    }

    //shifts elements towards right from i till j
    private void rotateRight(int i, int j, int[] A) {

        if (j == A.length) {
            return;
        }
        int requiredVal = A[j]; //value to be put at ith index
        for (int k = j; k > i; k--) {
            A[k] = A[k - 1];
        }
        A[i] = requiredVal; //put the value at ith index after shifting
    }
}
/*
Alternate positive and negative elements
Problem Description

Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.

If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

Note: Try solving with O(1) extra space.



Problem Constraints
1 <= length of the array <= 7000
-109 <= A[i] <= 109



Input Format
The first argument given is the integer array A.



Output Format
Return the modified array.



Example Input
Input 1:

 A = [-1, -2, -3, 4, 5]
Input 2:

 A = [5, -17, -100, -11]


Example Output
Output 1:

 [-1, 4, -2, 5, -3]
Output 2:

 [-17, 5, -100, -11]


Example Explanation
Explanation 1:

A = [-1, -2, -3, 4, 5]
Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]

 */
