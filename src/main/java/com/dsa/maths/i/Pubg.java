package com.dsa.maths.i;

public class Pubg {

    public int solve(int[] A) {

        int gcdArray = 0;
        //greater strength player can't attack lesser strength player because that will not give minimum health
        //gcd of the array is the answer
        //because repeated subtraction of strength will occur till strength becomes 0 which means gcd
        for (int i = 0; i < A.length; i++) {
            gcdArray = gcd(gcdArray, A[i]);
        }
        return gcdArray;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
