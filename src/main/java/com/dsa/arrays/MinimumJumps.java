package com.dsa.arrays;

public class MinimumJumps {

    public int solve(int[] A) {

        int end = 0;
        int jumps = 0;
        int farthest = 0;

        for (int i = 0; i < A.length - 1; i++) {
            farthest = Math.max(farthest, i + A[i]); // max jump possible at index i

            if (i > end) {// not possible to reach last
                return -1;
            }

            if (i == end) {// need to jump
                jumps++;
                end = farthest;// update where farthest jump will take you
            }
        }
        return jumps;

        // if (A[0] == 0 || A.length <= 1)
        //     return -1;

        // int ladder = A[0];
        // int stairs = ladder - 0; //stairs = ladder - i

        // int jumps = 0;
        // for (int i = 1; i < A.length; i++) {

        //     //store the max length ladder available till that time, discard smaller ladders
        //     //smaller ladder implies smaller jump
        //     //we added i to A[i] because from i we can jump to i+A[i] position, so ladder length is also i+A[i]
        //     ladder = Math.max(ladder, i + A[i]);

        //     if (i == A.length - 1) {
        //         return jumps + 1;// adding 1 for the final landing jump
        //     }
        //     //decrement stairs as we traverse the array
        //     stairs--;

        //     //when no more stairs to climb, we need to make a jump
        //     //now we jump to next available max ladder with no. of stairs = ladder - i
        //     if (stairs == 0) {
        //         jumps++;
        //         stairs = ladder - i;
        //     }
        // }

        // return -1;

        // if (A[0] == 0 || A.length <= 1){
        //     return -1;
        // }


    }
}
/*
Minimum number of jumps
Problem Description

Given an array of non-negative integers A where each element represents your maximum jump length at that position.
The initial position is the first index of the array and goal is to reach the last index of the array with the minimum number of jumps.

Note: If it not possible to reach the last index return -1 instead.



Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum number of jumps to reach the last index or -1 if it is not possible.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

Initial position is the first index.
From index 0 we can only jump to index 1 as first element is 0.
From index 1 we can jump to index 2 or index 3.
From index 2 we can reach the last index i.e. 4 in 1 jump.
so, the minimum number of jumps required is 3.

 */