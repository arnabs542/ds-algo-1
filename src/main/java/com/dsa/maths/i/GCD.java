package com.dsa.maths.i;

public class GCD {

    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        //refer class notes for derivation
        return gcd(B, A % B);
    }
}

