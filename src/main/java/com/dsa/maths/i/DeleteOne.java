package com.dsa.maths.i;

public class DeleteOne {

    public int solve(int[] A) {

        int length = A.length;

        int[] prefix = new int[length];
        prefix[0] = A[0];

        int[] suffix = new int[length];
        suffix[length - 1] = A[length - 1];

        //store gcd of all no.s from 0 to i
        for (int i = 1; i < length; i++) {
            prefix[i] = gcd(prefix[i - 1], A[i]);
        }

        //store gcd of all no.s from last to i
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], A[i]);
        }

        int maxGcd = 1;

        //get the gcd of remaining array (excluding current element) by prefix and suffix gcds
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                maxGcd = Math.max(suffix[i + 1], maxGcd);
            } else if (i == length - 1) {
                maxGcd = Math.max(prefix[i - 1], maxGcd);
            } else {
                maxGcd = Math.max(maxGcd, gcd(prefix[i - 1], suffix[i + 1]));
            }
        }
        return maxGcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
/*
Delete one
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:


 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.

 */
