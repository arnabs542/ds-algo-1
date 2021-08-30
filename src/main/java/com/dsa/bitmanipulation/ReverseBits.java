package com.dsa.bitmanipulation;

public class ReverseBits {
    public long reverse(long a) {

        long ans = 0L;

        for (int i = 0; i <= 31; i++) {
            //determine set bits
            if ((a & (1 << i)) != 0) {
                ans |= 1L << (31 - i); // left shift 1 by 31-i times to mark the MSB of reversed no.
            }
        }
        return ans;
    }
}
