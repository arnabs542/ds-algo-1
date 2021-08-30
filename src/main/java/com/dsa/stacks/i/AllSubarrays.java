package com.dsa.stacks.i;

import java.util.Stack;

public class AllSubarrays {
    public int solve(int[] A) {

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {

            while (!stack.empty()) {
                max = Math.max(max, A[i] ^ A[stack.peek()]);
                if (A[stack.peek()] > A[i]) {
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return max;
    }
}


