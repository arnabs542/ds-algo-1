package com.dsa.searching.i;

public class MaximumHeightStaircase {

    public int solve(int A) {

        //1+2+3+4+....+X = X*(X+1)/2
        int l = 0;
        int r = A; //can't be greater than this, so upper limit can be fixed

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            long bricksNeeded = Long.valueOf(mid) * Long.valueOf(mid + 1L) / 2L;

            if (bricksNeeded > Long.valueOf(A)) {//you can't have mid levels, so go down
                r = mid - 1;
            } else {//you can have mid levels, but still check if can go higher than this level
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}
/*
Maximum height of staircase
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.

The first stair would require only one block, the second stair would require two blocks and so on.

Find and return the maximum height of the staircase.



Problem Constraints
0 <= A <= 109


Input Format
The only argument given is integer A.



Output Format
Return the maximum height of the staircase using these blocks.



Example Input
Input 1:

 A = 10
Input 2:

 20


Example Output
Output 1:

 4
Output 2:

 5

 */