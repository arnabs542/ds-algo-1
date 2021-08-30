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

