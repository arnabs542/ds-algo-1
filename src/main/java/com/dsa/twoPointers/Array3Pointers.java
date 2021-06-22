package com.dsa.twoPointers;

public class Array3Pointers {
    public int minimize(final int[] A, final int[] B, final int[] C) {

        int minDiffSoFar = Integer.MAX_VALUE;

        int i = 0; //pointer to A
        int j = 0; //pointer to B
        int k = 0; //pointer to C

        while (i < A.length && j < B.length && k < C.length) {
            int min = Math.min(A[i], Math.min(B[j], C[k])); //min among the three
            int max = Math.max(A[i], Math.max(B[j], C[k])); //max among the three

            minDiffSoFar = Math.min(minDiffSoFar, max - min); //min diff. so far

            if (minDiffSoFar == 0) {
                break; //can't get any diff lesser than 0
            }
            //increment pointer in the array that has min value among the three
            //this will only give us the answer, as increasing pointer in array having max or 2nd max will only increase the diff. further
            if (A[i] == min) {
                i++;
            } else if (B[j] == min) {
                j++;
            } else {
                k++;
            }
        }
        return minDiffSoFar;
    }
}
/*
Array 3 Pointers
Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints
0 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107



Input Format
First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format
Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Example Input
Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 With 10 from A, 15 from B and 10 from C.
Explanation 2:

 With 3 from A, 2 from B and 3 from C.

 */
