package com.dsa.twoPointers;

public class ClosestPairFromSortedArrays {
    public int[] solve(int[] A, int[] B, int C) {

        int aPtr = 0;//pointer to A array
        int bPtr = B.length - 1; //pointer to B array

        int minSoFar = Integer.MAX_VALUE; //min Math.abs(A[i] + B[j] - C) so far
        int a = 0; //min A[i] so far
        int b = 0; //min B[j] so far

        while (aPtr <= A.length - 1 && bPtr >= 0) {
            int sum = A[aPtr] + B[bPtr];

            if (minSoFar > Math.abs(sum - C)) {
                minSoFar = Math.abs(sum - C); //update minSoFar
                a = A[aPtr]; //update a
                b = B[bPtr]; //update b
            } else if (minSoFar == Math.abs(sum - C)) {
                if (A[aPtr] < a || (B[bPtr] < b && A[aPtr] == a)) { //update because we need smallest a first and then smallest b
                    a = A[aPtr];
                    b = B[bPtr];
                }
            }
            if ((sum > C) || (aPtr == A.length - 1)) {
                bPtr--; //decrement bPtr if sum > C or aPtr has reached end
            } else if ((sum < C) || (bPtr == 0)) {
                aPtr++; //increment aPtr if sum < C or bPtr has reached start
            } else {
                a = A[aPtr];
                b = B[bPtr];
                break;
            }
        }
        return new int[]{a, b};
    }
}
/*
Closest pair from sorted arrays
Problem Description

Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.



Problem Constraints
1 <= length of both the arrays <= 100000

1 <= A[i], B[i] <= 109

1 <= C <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.



Output Format
Return an array of size 2 denoting the pair which has sum closest to C.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:

 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13


Example Output
Output 1:

 [1, 8]
Output 2:

 [10, 2]


Example Explanation
Explanation 1:

 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
Explanation 2:

 [10, 2] is the only pair such abs(10+2-13) is minimum.

 */
