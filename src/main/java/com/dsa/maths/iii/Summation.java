package com.dsa.maths.iii;

public class Summation {

    public int solve(int n) {
        int p = (int) Math.pow(10, 9) + 7;
        long ans = (((n * (n - 1)) % p) * (power(3, n - 2, p) % p)) % p; //refer class notes for derivation

        return (int) (ans);
    }

    private long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p);
        }
        return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
    }
}
