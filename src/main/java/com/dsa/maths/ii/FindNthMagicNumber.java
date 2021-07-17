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
/*
Find nth Magic Number
Problem Description

Given an integer A, find and return the Ath magic number.

A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….



Problem Constraints
1 <= A <= 5000



Input Format
The only argument given is integer A.



Output Format
Return the Ath magic number.



Example Input
Example Input 1:

 A = 3
Example Input 2:

 A = 10


Example Output
Example Output 1:

 30
Example Output 2:

 650


Example Explanation
Explanation 1:

 A in increasing order is [5, 25, 30, 125, 130, ...]
 3rd element in this is 30
Explanation 2:

 In the sequence shown in explanation 1, 10th element will be 650.

 */
