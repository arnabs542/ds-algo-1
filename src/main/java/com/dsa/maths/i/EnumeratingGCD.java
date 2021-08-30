package com.dsa.maths.i;

public class EnumeratingGCD {

    public String solve(String A, String B) {
        if (A.equals(B)) {
            return A;
        }
        //because gcd(p,p+1) = 1, so gcd(p,p+1.....,q) = 1 unless p=q
        return "1";
    }
}
