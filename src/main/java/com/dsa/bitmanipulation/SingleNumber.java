package com.dsa.bitmanipulation;

public class SingleNumber {

    public int singleNumber(final int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {//xor of even no. of duplicates will become zero, leaving out the single no.
            xor ^= A[i];
        }
        return xor;
    }
}
