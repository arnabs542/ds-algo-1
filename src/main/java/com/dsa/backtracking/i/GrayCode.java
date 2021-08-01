package com.dsa.backtracking.i;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        recurse(ans, N);
        return ans;
    }

    private void recurse(ArrayList<Integer> arr, int N) {
        if (N == 1) { //add 0 and 1 in order
            arr.add(0);
            arr.add(1);
            return;
        }
        recurse(arr, N - 1);
        for (int i = arr.size() - 1; i >= 0; i--) {//eg: for N==2 take each no. of N=1 case from backwards and add to it 10 (i.e 1 << (2-1) )
            arr.add(arr.get(i) + (1 << (N - 1)));
        }
    }
}
/*
Gray Code
Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints
1 <= A <= 16



Input Format
First argument is an integer A.



Output Format
Return an array of integers representing the gray code sequence.



Example Input
Input 1:

A = 2
Input 1:

A = 1


Example Output
output 1:

[0, 1, 3, 2]
output 2:

[0, 1]


Example Explanation
Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].

 */