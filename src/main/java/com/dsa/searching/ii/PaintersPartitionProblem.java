package com.dsa.searching.ii;

public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {

        long l = 0;
        long r = 0;//has the sum of all elements in C, max time taken (occurs when only one painter is there)

        for (int i = 0; i < C.length; i++) {
            r += C[i];
        }

        long ans = 0;
        //binary search on the possible time takens
        while (l <= r) {
            long mid = l + ((r - l) / 2);

            //check if lesser time possible than mid time
            if (isLesserTimePossible(A, C, mid)) {
                r = mid - 1L;
                ans = mid;
            } else {
                l = mid + 1L;
            }
        }
        long a = (B) * (ans % 10000003);
        return (int) (a % 10000003);
    }

    private boolean isLesserTimePossible(int A, int[] C, long currTime) {

        int noOfsubArrays = 1;
        long totalTime = 0;

        for (int i = 0; i < C.length; i++) {
            if (C[i] > currTime) {//if one element not making it possible, summing with others also wont make it possible
                return false;
            }
            totalTime += C[i];//keep adding

            //if totalTime gets greater, increase noOfsubArrays because subarray till then was satisfying.
            //Now check again for next subarray, so reset total time to C[i]
            if (totalTime > currTime) {
                totalTime = C[i];
                noOfsubArrays++;
            }
        }

        return noOfsubArrays <= A; //possible only if no. of painters needed to make it possible are atmost A
    }
}
/*
Painter's Partition Problem
Problem Description

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. Which means a configuration where painter 1 paints board 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106



Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.



Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.



Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]


Example Output
Output 1:

 50
Output 2:

 11


Example Explanation
Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50%10000003
Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11%10000003

 */