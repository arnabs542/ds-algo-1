package com.dsa.maths.i;

public class DeleteElements {

    public int solve(int[] A) {

        int gcdArray = 0;
        for (int i = 0; i < A.length; i++) {
            gcdArray = gcd(gcdArray, A[i]);
        }

        //if gcd of array is 1, means no need to remove any element
        if (gcdArray == 1) {
            return 0;
        }
        //if gcd of array is not 1, means no matter how many elements you remove, gcd of remaining array can't be 1
        return -1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

