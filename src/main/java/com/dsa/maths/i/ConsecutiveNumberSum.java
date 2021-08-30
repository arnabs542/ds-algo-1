package com.dsa.maths.i;

public class ConsecutiveNumberSum {

    public int solve(int A) {
        // A = a+(a+1)+(a+2)+....+(a+M)
        // a = [A - ((M*(M+1))/2)] / (M+1)
        // for 0 <= ((M*(M+1))/2) < A, keep checking if a is natural number or not
        int i = 0;
        int count = 0;

        while ((A - ((i * (i + 1)) / 2)) > 0) {
            if ((A - ((i * (i + 1)) / 2)) % (i + 1) == 0) {
                count++;
            }
            i++;
        }
        return count;
    }

}
