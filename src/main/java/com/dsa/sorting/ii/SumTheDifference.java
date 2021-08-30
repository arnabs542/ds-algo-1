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
