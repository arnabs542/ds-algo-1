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
/*
Factorial Array
Problem Description

Groot has an array A of size N. Boring right? Groot thought so too, so he decided to construct another array B of the same size and defined elements of B as:

B[i] = factorial of A[i] for every i such that 1<= i <= N.

factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non empty set of prime factors.

Since the number can be very large, return it modulo 109 + 7.

NOTE: A set is a data structure having only distinct elements. Eg : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106
Your code will run against a maximum of 5 test cases.



Input Format
Only argument is an integer array A of size N.



Output Format
Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 109+7.



Example Input
Input 1:

 A = [2, 3, 2, 3]
Input 2:

 A = [2, 3, 4]


Example Output
Output 1:

 6
Output 2:

 4


Example Explanation
Explanation 1:

 Array B will be : [2, 6, 2, 6]
 The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
Input 2:

 Array B will be : [2, 6, 24]
 The total possible subsequences are 4 : [2], [6], [24], [6, 24].

 */