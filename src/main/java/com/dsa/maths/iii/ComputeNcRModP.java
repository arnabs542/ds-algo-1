package com.dsa.maths.iii;

public class ComputeNcRModP {
    private long[] fact;

    public int solve(int n, int r, int p) {
        constructFactorialArray(n, p);

        long ans = (inverseMod(fact[n - r], p) % p) * (inverseMod(fact[r], p) % p);
        long ans1 = (fact[n] * (ans % p));
        return (int) (ans1 % p);
    }

    private void constructFactorialArray(int n, int p) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }
    }

    private long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p) % p;
        }
        return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
    }

    private long inverseMod(long a, int p) {
        return power(a, p - 2, p);
    }
}

