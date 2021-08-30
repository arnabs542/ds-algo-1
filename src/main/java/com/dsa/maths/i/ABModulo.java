package com.dsa.maths.i;

public class ABModulo {

    public int solve(int A, int B) {
        //A-aM = B-bM
        //A-B = (a-b)M
        //max possible M = A-B
        return Math.abs(A - B);
    }
}
