package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NIntegersContainingOneTwoThree {
    public ArrayList<Integer> solve(int A) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] nos = new int[]{1, 2, 3};

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0); //add 0, to generate initial no.s 1,2 and 3

        while (ans.size() < A) {
            int currNo = deque.pollFirst(); //pop first elem
            if (currNo != 0) {
                ans.add(currNo);
            }
            for (int i = 0; i < nos.length; i++) { //generate all possible no.s with currNo
                Integer num = currNo * 10 + nos[i];
                deque.addLast(num);
            }
        }
        return ans;
    }
}
/*
N integers containing only 1, 2 & 3
Problem Description

Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.

NOTE: All the A integers will fit in 32 bit integer.



Problem Constraints
1 <= A <= 29500



Input Format
The only argument given is integer A.



Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input
Input 1:

 A = 3
Input 2:

 A = 7


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation
Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

 */