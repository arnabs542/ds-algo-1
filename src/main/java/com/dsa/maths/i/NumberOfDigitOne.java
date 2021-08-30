package com.dsa.maths.i;

public class NumberOfDigitOne {

    public int solve(int A) {

        int n = A;
        int count = 0;
        for (int i = 1; i <= A; i *= 10) {
            int divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max((n % divider) - i + 1, 0), i); //formula, refer class notes (TA session)
        }
        return count;
    }
}
