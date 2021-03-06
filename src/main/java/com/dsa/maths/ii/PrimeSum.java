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
/*
Prime Sum
Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints
4 <= A <= 2*107



Input Format
First and only argument of input is an even number A.



Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input
 4


Example Output
 [2, 2]


Example Explanation
 There is only 1 solution for A = 4.

 */
