package com.dsa.bitmanipulation;

public class SingleNumberII {
    public int singleNumber(final int[] A) {

        int ans = 0;
        for (int i = 0; i <= 31; i++) {

            int countOne = 0;  //count of no.s that have bit set at ith position
            int mask = 1 << i;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & mask) != 0) {
                    countOne++;
                }
            }
            //since elements occur thrice, if countOne is not multiple of 3 it means the odd one has ith bit set
            if ((countOne % 3) == 1) {
                ans |= mask;
            }
        }
        return ans;
    }
}
/*
Single Number II
Problem Description

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints
2 <= A <= 5*106

0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.

 */