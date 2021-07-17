package com.dsa.maths.ii;

import java.util.Arrays;

public class CountDivisors {
    public int[] solve(int[] A) {

        //Sieve Approach O(n log n)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int[] factors = new int[max + 1];
        Arrays.fill(factors, 1); // 1 is a factor of every number

        //increase factors[j] by 1 for every j which is a multiple of i
        for (int i = 2; i < factors.length; i++) {
            for (int j = i; j < factors.length; j += i) {
                factors[j]++;
            }
        }
        //now factors array has count of factors
        int[] ans = new int[A.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = factors[A[i]];
        }
        return ans;
    }

    // O(n n^1/2)
//    private int noOfFactors(int n) {
//        int count = 0;
//        for (int i = 1; i * i <= n; i++) {
//            if (n % i == 0) {
//                if (n != i * i) {
//                    count += 2;
//                } else {
//                    count += 1;
//                }
//            }
//        }
//        return count;
//    }
}
/*
Count of divisors
Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: Order of the resultant array should be same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].

 */