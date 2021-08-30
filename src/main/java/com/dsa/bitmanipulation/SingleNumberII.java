package com.dsa.bitmanipulation;

public class SingleNumberII {
    public int singleNumber(final int[] A) {

        int ans = 0;
        for (int i = 0; i <= 31; i++) {

            int countOne = 0;  //count of no.s that have bit set at ith position
            int mask = 1 << i;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & mask) != 0) {
                    countOne++;
                }
            }
            //since elements occur thrice, if countOne is not multiple of 3 it means the odd one has ith bit set
            if ((countOne % 3) == 1) {
                ans |= mask;
            }
        }
        return ans;
    }
}
