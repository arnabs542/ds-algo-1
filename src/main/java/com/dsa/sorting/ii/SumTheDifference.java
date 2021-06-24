package com.dsa.sorting.ii;

import java.util.Arrays;

public class SumTheDifference {

    private static int p = 1000000007;
    public int solve(int[] A) {

        Arrays.sort(A);
        long ans = 0L;

        for (int i = 0; i < A.length; i++) {
            ans = (ans + (power(2, i) * A[i]) % p) % p; // no. at i will be largest in 2^i subsequences
            ans = (ans - (power(2, A.length - 1 - i) * A[i]) % p + p) % p; // no. at i will be smallest in 2^(N-1-i) subsets
        }
        return (int) (ans % p);
    }

    private long power(long a, long b) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return 0L;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2);
        } else {
            return (a * (power((a * a) % p, (b - 1) / 2))) % p;
        }
    }
}
/*
Sum the Difference
Problem Description

Given an integer array A of size N.
You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints
1 <= N <= 10000

1<= A[i] <=1000



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the output.



Example Input
Input 1:

A = [1, 2]
Input 2:

A = [1]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1
Explanation 2:

 Only 1 subsequence of 1 element is formed.
 */