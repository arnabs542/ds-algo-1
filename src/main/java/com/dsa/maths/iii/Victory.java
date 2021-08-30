package com.dsa.maths.iii;

public class Victory {

    private int p = (int) Math.pow(10, 9) + 7;

    public int solve(int A, int B, int C) {
        // winProb = 1/B;
        // lossProb = (B-1)/B;

        long ans1 = nCr(A - 1, C - 1);
        long ans2 = inverseMod(power(B, C) % p) % p;
        long ans3 = power((B - 1), (A - C)) % p;
        long ans4 = inverseMod(power(B, (A - C)) % p) % p;

        long ans5 = (ans1 * ans2) % p;
        long ans6 = (ans5 * ans3) % p;
        long ans7 = (ans6 * ans4) % p;

        return (int) (ans7 % p);
    }

    private long nCr(int n, int r) {
        // Since C(n, r) = C(n, n-r)
        //we will only multiply till n-r, this helps in overcoming TLE as no. of computations will be reduced
        r = Math.min(r, n - r);

        long res = 1;
        // Calculate value of [n * (n-1) *---* (n-r+1)] / [r * (r-1) *----* 1]
        for (int i = 1; i <= r; ++i) {
            res = (res * (n - (i - 1))) % p;
            res = (res * inverseMod(i)) % p;
        }
        return res;
    }

    private long power(long a, long b) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2);
        }
        return (a * (power((a * a) % p, (b - 1) / 2) % p)) % p;
    }

    private long inverseMod(long a) {
        return power(a, p - 2);
    }


}
