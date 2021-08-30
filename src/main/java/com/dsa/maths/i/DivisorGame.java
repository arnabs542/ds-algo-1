package com.dsa.maths.i;

public class DivisorGame {

    public int solve(int A, int B, int C) {
        //positive integer divisible by B and C is multiples of LCM
        int lcm = (B * C) / gcd(B, C);
        return A / lcm;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

