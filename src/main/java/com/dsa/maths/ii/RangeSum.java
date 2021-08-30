package com.dsa.maths.ii;

public class RangeSum {

    private int p = 1000000007;

    //    S(l,r) = F(l) + F(l+1) + ... + F(r)
    // => S(l,r) = F(r+2)-F(l+1)  since S(n) = F(n+2) - F(1) and S(l,r) = S(r) - S(l-1)
    public int solve(int A, int B) {
        if (A == B) {
            return (int) fibonacci(A) % p;
        }
        return (int) (((fibonacci(B + 2) % p) - (fibonacci(A + 1) % p) + p) % p);
    }

    private long[][] multiplyTwo2x2Matrices(long[][] a, long[][] b) {
        long zeroZero = (((a[0][0] * b[0][0]) % p) + ((a[0][1] * b[1][0]) % p)) % p;
        long zeroOne = (((a[0][0] * b[0][1]) % p) + ((a[0][1] * b[1][1]) % p)) % p;
        long oneZero = (((a[1][0] * b[0][0]) % p) + ((a[1][1] * b[1][0]) % p)) % p;
        long oneOne = (((a[1][0] * b[0][1]) % p) + ((a[1][1] * b[1][1]) % p)) % p;

        return new long[][]{{zeroZero, zeroOne}, {oneZero, oneOne}};
    }

    private long[][] power(long[][] m, int n) {

        if (n == 0) {
            return new long[][]{{1L, 0L}, {0L, 1L}};//identity matrix
        } else if (n == 1) {
            return m;
        }
        long a[][] = new long[][]{{1L, 1L}, {1L, 0L}};

        m = power(m, n / 2);
        m = multiplyTwo2x2Matrices(m, m);

        if (n % 2 != 0) {
            m = multiplyTwo2x2Matrices(m, a);
        }
        return m;
    }

    //0(log(n)) solution using matrix exponentiation
    //refer notes
    private long fibonacci(int n) {
        long a[][] = new long[][]{{1L, 1L}, {1L, 0L}};

        return power(a, n - 1)[0][0];
    }
}

