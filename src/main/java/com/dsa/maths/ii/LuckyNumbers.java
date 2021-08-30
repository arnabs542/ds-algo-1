package com.dsa.maths.ii;

import java.util.Arrays;

public class LuckyNumbers {
    public int solve(int A) {

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

        //factors will store distinct prime factors for number i at ith index
        int[] factors = new int[A + 1];
        Arrays.fill(factors, 0); //initialize with 0 prime factors

        for (int i = 2; i <= A; i++) {
            if (primes[i]) {
                //increase factors[j] count for every multiple of i
                for (int j = i; j <= A; j += i) {
                    factors[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 3; i <= A; i++) {
            if (factors[i] == 2) {
                count++;
            }
        }
        return count;
    }

}

