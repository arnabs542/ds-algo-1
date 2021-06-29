package com.dsa.bitmanipulation;

import java.util.Arrays;

public class MinXORValue {
    public int findMinXor(int[] A) {
        //min xor occurs when most of the bits btn two no.s are same
        //for a no. a, it will have min xor with either a-1 or a+1
        //sorting will help compare pairwise min xors
        Arrays.sort(A);

        int minXor = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            minXor = Math.min(minXor, A[i] ^ A[i - 1]);
        }
        return minXor;
    }
}
/*
Min XOR value
Problem Description

Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting minimum xor value.



Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 0 xor 2 = 2

 */