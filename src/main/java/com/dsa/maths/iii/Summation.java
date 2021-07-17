package com.dsa.maths.iii;

public class Summation {

    public int solve(int n) {
        int p = (int) Math.pow(10, 9) + 7;
        long ans = (((n * (n - 1)) % p) * (power(3, n - 2, p) % p)) % p; //refer class notes for derivation

        return (int) (ans);
    }

    private long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p);
        }
        return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
    }
}
/*
SUMMATION
Problem Description

Given an integer A.

Calculate the sum = (ACr) * (r) * (r - 1) * (2r-2) for all r from 0 to A.

Return sum % 109 + 7.



Problem Constraints
2 <= A <= 106



Input Format
The first and only argument given is the integer A.



Output Format
Return a single integer denoting sum % 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 4


Example Output
Output 1:

 18
Output 2:

 108


Example Explanation
Explaination 1:

 (ACr) * (r) * (r - 1) * (2r-2)
 r = 0, (1) * (0) * (1) * (1/4) = 0
 r = 1, (3) * (1) * (0) * (1/2) = 0
 r = 2, (3) * (2) * (1) * (1) = 6
 r = 3, (1) * (3) * (2) * (2) = 12
 sum = 18

 */