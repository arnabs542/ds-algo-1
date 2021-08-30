package com.dsa.maths.ii;

public class OddFibonacci {
    public int solve(int A, int B) {

        //F(3x) is even, rest all are odd
        int a = A;
        int b = B - (B % 3); //first no. before B that is divisible by 3

        if (A % 3 != 0) {
            a = A + (3 - A % 3); //first no. after A that is divisible by 3
        }

        int multiplesOf3 = ((b - a) / 3) + 1;
        return (B - A + 1) - multiplesOf3;
    }
}
