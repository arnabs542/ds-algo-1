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

