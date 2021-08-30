package com.dsa.maths.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FactorialArray {

    private boolean[] primes;

    public int solve(int[] A) {

        int max = Integer.MIN_VALUE;
        //get the max element in the array
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        //create a sieve, sieve is an array from indices 1 to max element marked with true if element is prime
        //refer notes
        sieve(max);

        //store last prime
        int lastPrime = 0;
        Map<Integer, Integer> primeMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 2) {
                continue;
            }
            lastPrime = largestPrime(A[i]); //get largest prime less than A[i], it is enough to know this as we have factorials

            //check if lastPrime already in the map, if yes update count else insert
            if (primeMap.containsKey(lastPrime)) {
                int count = primeMap.get(lastPrime);
                count++;
                primeMap.put(lastPrime, count);
            } else {
                primeMap.put(lastPrime, 1);
            }
        }
        // total no. of subsequences of array of length n = 2^n (2^n - 1, if we exclude empty subsequence)
        int noOfSubsequences = 0;
        for (Map.Entry<Integer, Integer> entry : primeMap.entrySet()) {
            noOfSubsequences += ((int) (Math.pow(2, entry.getValue())) - 1) % ((int) (Math.pow(10, 9)) + 7);
        }
        return (noOfSubsequences);
    }

    private void sieve(int max) {
        primes = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= max && j > 0; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    private int largestPrime(int N) {
        for (int i = N; i > 1; i--) {
            if (primes[i]) {
                return i;
            }
        }
        return 0;
    }
}
