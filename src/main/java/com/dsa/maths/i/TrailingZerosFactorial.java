package com.dsa.maths.i;

public class TrailingZerosFactorial {

    public int trailingZeroes(int A) {
        //formula = A/5 + A/25 + A/125 .......
        int count = 0;
        int base = 5;

        while (A != 0) {
            count += A / base;
            A /= base;
        }
        return count;
    }
}
