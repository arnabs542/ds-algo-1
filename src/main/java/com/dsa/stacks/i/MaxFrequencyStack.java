package com.dsa.stacks.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {
    public int[] solve(int[][] A) {

        int[] ans = new int[A.length];

        Map<Integer, Integer> elemMap = new HashMap<>(); //key: element, value: frequency of element
        Map<Integer, Stack<Integer>> freqMap = new HashMap<>(); //key: frequency, value: Stack of elements

        int maxFreq = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            if (A[i][0] == 1) { //push operation

                int elem = A[i][1]; //curr elem
                elemMap.put(elem, elemMap.getOrDefault(elem, 0) + 1); //update elem frequency

                int freq = elemMap.get(elem); //freq of elem
                freqMap.computeIfAbsent(freq, z -> new Stack<>()).push(elem);
                maxFreq = Math.max(maxFreq, freq); //update max freq

                ans[i] = -1;
            } else {

                Stack<Integer> stack = freqMap.get(maxFreq);
                int elem = stack.pop(); //get top stack elem of maxFreqStack

                if (stack.empty()) { //stack is empty means no more elems in curr freq, so reduce it by 1
                    maxFreq--;
                }
                elemMap.put(elem, elemMap.getOrDefault(elem, 0) - 1);
                ans[i] = elem;
            }
        }
        return ans;
    }
}
/*
Maximum Frequency stack
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation
Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations

 */
