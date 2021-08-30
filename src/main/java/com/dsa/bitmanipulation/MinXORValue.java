package com.dsa.bitmanipulation;

import java.util.Arrays;

public class MinXORValue {
    public int findMinXor(int[] A) {
        //min xor occurs when most of the bits btn two no.s are same
        //for a no. a, it will have min xor with either a-1 or a+1
        //sorting will help compare pairwise min xors
        Arrays.sort(A);

        int minXor = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            minXor = Math.min(minXor, A[i] ^ A[i - 1]);
        }
        return minXor;
    }
}
