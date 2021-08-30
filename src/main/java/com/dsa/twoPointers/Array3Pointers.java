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

