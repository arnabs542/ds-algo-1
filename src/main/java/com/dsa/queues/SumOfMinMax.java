package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfMinMax {
    private int mod = 1000000007;

    public int solve(int[] A, int B) {

        Deque<Integer> maxDeque = new ArrayDeque<>(); //indexes
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int i = 0; i < B; i++) {
            //pop unnecessary elems from maxDeque (from rear)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            //pop unncesseaary elems from minDeque (from rear)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
        }

        long sum = 0L;
        for (int j = B; j < A.length; j++) {

            sum = (sum + (A[maxDeque.peekFirst()] + A[minDeque.peekFirst()] + mod) % mod + mod) % mod;

            //elem moving out is the max, remove it
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() == j - B) {
                maxDeque.pollFirst();
            }
            //elem moving out is the min, remove it
            if (!minDeque.isEmpty() && minDeque.peekFirst() == j - B) {
                minDeque.pollFirst();
            }
            //pop unnecessary elems from maxDeque (from rear)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[j]) {
                maxDeque.pollLast();
            }
            //pop unncesseaary elems from minDeque (from rear)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[j]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(j);
            minDeque.addLast(j);
        }
        sum = (sum + (A[maxDeque.peekFirst()] + A[minDeque.peekFirst()] + mod) % mod + mod) % mod;
        return (int) sum;
    }
}
/*
Sum of min and max
Problem Description

Given an array A of both positive and negative integers.

Your task is to compute sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are :
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4
    Sum of all min & max = 6 + 4 + 4 + 4 = 18
Explanation 2:

 Subarrays of size 2 are :
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3

 */
