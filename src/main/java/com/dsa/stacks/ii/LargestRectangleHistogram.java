package com.dsa.stacks.ii;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] A) {

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

