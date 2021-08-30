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
