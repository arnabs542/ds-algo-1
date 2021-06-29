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
/*
Strange Equality
Problem Description

Given an integer A.
Two numbers X and Y are defined as follows:

X is the greatest number smaller than A such that XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A such that XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the XOR of X and Y.



Example Input
A = 5


Example Output
10


Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.

 */