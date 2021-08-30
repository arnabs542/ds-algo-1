package com.dsa.bitmanipulation;

public class StrangeEquality {
    public int solve(int A) {

        // A+X = A^X
        // => A&X = 0

        int pos = 0;//pos stores the index of the MSB bit
        for (int i = 31; i >= 0; i--) {
            if ((A & (1 << i)) > 0) {
                pos = i;
                break;
            }
        }

        //X will be nothing but flipping all bits of A from 0 till MSB
        //for 1010, X = 0101
        int x = A;
        for (int i = 0; i <= pos; i++) {
            x ^= (1 << i);
        }

        //Y will be nothing but 1 left shifted by pos+1 times
        // for 1010, Y = 10000
        int y = (1 << (pos + 1));

        return x ^ y;
    }
}
