package com.dsa.arrays;

public class FirstMissingInteger {

    public int firstMissingPositive(int[] A) {

        // Answer condition is (1 <= Ans <= A.length + 1)
        // So put element at ith position at its right position, which is A[i]-1
        // After this operation array elements will be in sorted fashion, so in one more iteration we can find out first missing positive

        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 >= 0 && A[i] - 1 < A.length && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
/*
First Missing Integer
Problem Description

Given an unsorted integer array A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the first missing positive integer.



Example Input
Input 1:

[1, 2, 0]
Input 2:

[3, 4, -1, 1]
Input 3:

[-8, -7, -6]


Example Output
Output 1:

3
Output 2:

2
Output 3:

1


Example Explanation
Explanation 1:

A = [1, 2, 0]
First positive integer missing from the array is 3.

 */
