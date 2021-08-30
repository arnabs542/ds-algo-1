package com.dsa.maths.ii;

public class FindNthMagicNumber {

    public int solve(int A) {

        //pattern is 5^1, 5^2, 5^1+5^2, ......
        //represented as 001, 010, 011, 100, 101, 110
        //3rd magic number = 0*(5^3) + 1*(5^2) + 1*(5^1)
        int no = 0;
        int i = 1;  //LSB is 1 not 0
        while (A > 0) {
            //if LSB is set, it will contribute
            if ((A & 1) != 0) {
                no += Math.pow(5, i);
            }
            A = A >> 1;//right shift to make next bit appear at LSB
            i++;
        }
        return no;
    }
}

