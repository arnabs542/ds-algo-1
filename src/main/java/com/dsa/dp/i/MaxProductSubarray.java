package com.dsa.dp.i;

public class MaxProductSubarray {
    public int maxProduct(final int[] A) {

        int minSoFar = A[0];
        int maxSoFar = A[0];
        int ans = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) { //if current no. is negative, swap minSoFar and maxSoFar
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(A[i], maxSoFar * A[i]); //update maxSoFar
            minSoFar = Math.min(A[i], minSoFar * A[i]); //update minSoFar

            ans = Math.max(ans, maxSoFar);
        }
        return ans;
    }
}
