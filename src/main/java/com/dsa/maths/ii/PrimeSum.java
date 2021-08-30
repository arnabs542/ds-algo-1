package com.dsa.maths.ii;

import java.util.Arrays;

public class PrimeSum {

    public int[] primesum(int A) {

        //sieve
        boolean[] primes = new boolean[A + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= A; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= A; j += i) {
                    primes[j] = false;
                }
            }
        }

        int[] ans = new int[2];
        //break if i & A-i are prime
        for (int i = 2; i <= A; i++) {
            if (primes[i] && primes[A - i]) {
                ans = new int[]{i, A - i};
                break;
            }
        }
        return ans;
    }
}

