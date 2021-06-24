package com.dsa.sorting.i;

public class MergeTwoSortedArrays {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A, final int[] B) {

        int[] ans = new int[A.length + B.length];
        int aPtr = 0;//pointer to array A
        int bPtr = 0;//pointer to array B
        int ansIdx = 0;//pointer to array ans

        while (ansIdx < A.length + B.length) {

            //add from A when B is exhausted or A[aPtr] <= B[bPtr]
            if ((aPtr < A.length) && (bPtr == B.length || A[aPtr] <= B[bPtr])) {
                ans[ansIdx++] = A[aPtr++];
            }
            //add from B when A is exhausted or A[aPtr] > B[bPtr]
            else if ((bPtr < B.length) && (aPtr == A.length || A[aPtr] > B[bPtr])) {
                ans[ansIdx++] = B[bPtr++];
            }
        }
        return ans;
    }
}
/*
Merge Two Sorted Arrays
Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i],B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2 ,11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.
 */
