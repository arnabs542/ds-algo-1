package com.dsa.bitmanipulation;

public class DifferentBitsSumPairwise {
    public int cntBits(int[] A) {

        long mod = 1000000007L;
        long hammingDist = 0;

        for (int i = 0; i < 32; i++) {
            int countOnes = 0;// count of no.s that have bit at i set
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) > 0) {//check if bit at i is set
                    countOnes++;
                }
            }
            //refer class notes for better understanding
            hammingDist += (2L * (countOnes) * (A.length - countOnes)) % mod;
        }
        return (int) (hammingDist % mod);
    }
}
