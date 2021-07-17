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
/*
Victory
Problem Description

Given three integers A, B, C.

Probability of India winning a match against Pakistan is 1/B.

Find the probability P of India winning Cth match in its Ath Match against Pakistan. If P = Q/R, return (Q * (R-1)) modulo 109+7.

NOTE: India should win Ath match and that should be Cth win of India in total.



Problem Constraints
1 <= A <= 109
1 <= B <= 102
1 <= C <= 109
1 <= C <= A
0 <= A - C <= 106


Input Format
The first argument given is integer A.

The Second argument given is integer B.

The Third argument given is integer C.



Output Format
Find the probability P of India winning Cth match in its Ath Match against Pakistan.

If P = Q/R, return (Q * (R-1)) modulo 109+7.



Example Input
Input 1:

 A = 2
 B = 2
 C = 2
Input 2:

 A = 3
 B = 3
 C = 2


Example Output
Output 1:

 250000002
Output 2:

 481481485


Example Explanation
Explanation 1:

 P = W W = ( 1/2 )*( 1/2 ) = 1/4 = (1) * (4-1) mod 109+7 = 250000002
Explanation 2:

 P = W L W + L W W = ( 1/3 ) * ( 2/3 ) * ( 1/3 ) + ( 2/3 ) * ( 1/3 ) * ( 1/3 ) = 4/27

 */