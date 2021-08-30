package com.dsa.stacks.ii;

import java.util.Stack;

public class MaximumRectangle {
    public int solve(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int max = 0;
                int row = i;
                while (row >= 0) {
                    if (A[row--][j] == 0) {
                        break;
                    }
                    max += 1;
                }
                A[i][j] = max;
            }
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(A[i]));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] A) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < A.length; i++) {

            while ((stack.peek() != -1)
                    && (A[stack.peek()] >= A[i])) {
                int currHeight = A[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currHeight = A[stack.pop()];
            int currWidth = A.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        return maxArea;
    }
}

