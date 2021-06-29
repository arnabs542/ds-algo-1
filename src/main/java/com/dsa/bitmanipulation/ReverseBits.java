package com.dsa.bitmanipulation;

public class ReverseBits {
    public long reverse(long a) {

        long ans = 0L;

        for (int i = 0; i <= 31; i++) {
            //determine set bits
            if ((a & (1 << i)) != 0) {
                ans |= 1L << (31 - i); // left shift 1 by 31-i times to mark the MSB of reversed no.
            }
        }
        return ans;
    }
}
/*
Reverse Bits
Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000
=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011
=>      11000000000000000000000000000000

 */