package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegativeIntegerInWindowSizeB {

    public int[] solve(int[] A, int B) {

        Deque<Integer> queue = new ArrayDeque<>();//front of queue will have the first negative elem

        for (int i = 0; i < B; i++) { //check first window for negative no.
            if (A[i] < 0) {
                queue.add(A[i]);
            }
        }
        //if queue is empty, means no negative elem so put 0 (int[] initialized to 0 anyway)
        int[] ans = new int[A.length - B + 1];
        if (!queue.isEmpty()) {
            ans[0] = queue.peekFirst(); //update ans with first negative elem in first window
        }

        for (int j = B; j < A.length; j++) {
            if (!queue.isEmpty() && A[j - B] == queue.peekFirst()) { //if outgoing elem == front of queue, remove from queue
                queue.pollFirst();
            }
            if (A[j] < 0) { //incoming elem is negative, add to queue as it can be answer for future windows
                queue.add(A[j]);
            }
            if (!queue.isEmpty()) {
                ans[j - B + 1] = queue.peekFirst(); //update ans with first negative elem in current window
            }
        }
        return ans;
    }
}
/*
First negative integer in window size B
Problem Description

Given an array of integers A of size N and an integer B.

Find the first negative integer for each and every window(contiguous subarray) of size B.

If a window does not contain a negative integer, then return 0 for that window.



Problem Constraints
1 <= N <= 200000

-109 <= A[i] <= 109



Input Format
The arguments given are integer array A and integer B.



Output Format
Return an integer array of size N+1-B representing answer of the ith window.



Example Input
 Input 1:
    A = [-1, 2, 3, -4, 5]
    B = 2

Input 2:
    A = [-8, 2, 3, -6, 10]
    B = 2




Example Output
Output 1:
    [-1, 0, -4, -4]
Output 2:
    [-8, 0, -6, -6]


Example Explanation
Explaination For Input:-1
    window [2,3] doesn't contain any negative integer so it's answer will be 0 and rest all the windows have some negative integer.
 */
