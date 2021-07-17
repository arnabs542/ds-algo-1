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
/*
Consecutive Number Sum
Problem Description

Given an integer A.
Return number of ways we can write A as a sum of consecutive positive integers.



Problem Constraints
1 <= A <= 109



Input Format
The first argument given is the integer A.



Output Format
Return number of ways we can write A as a sum of consecutive positive integers.



Example Input
A = 9


Example Output
3


Example Explanation
A = 9
A = 2 + 3 + 4
A = 5 + 4

 */