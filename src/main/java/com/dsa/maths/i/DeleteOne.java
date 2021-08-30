package com.dsa.maths.i;

public class DeleteOne {

    public int solve(int[] A) {

        int length = A.length;

        int[] prefix = new int[length];
        prefix[0] = A[0];

        int[] suffix = new int[length];
        suffix[length - 1] = A[length - 1];

        //store gcd of all no.s from 0 to i
        for (int i = 1; i < length; i++) {
            prefix[i] = gcd(prefix[i - 1], A[i]);
        }

        //store gcd of all no.s from last to i
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], A[i]);
        }

        int maxGcd = 1;

        //get the gcd of remaining array (excluding current element) by prefix and suffix gcds
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                maxGcd = Math.max(suffix[i + 1], maxGcd);
            } else if (i == length - 1) {
                maxGcd = Math.max(prefix[i - 1], maxGcd);
            } else {
                maxGcd = Math.max(maxGcd, gcd(prefix[i - 1], suffix[i + 1]));
            }
        }
        return maxGcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

