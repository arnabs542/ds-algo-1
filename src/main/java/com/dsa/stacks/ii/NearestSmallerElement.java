package com.dsa.stacks.ii;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {

        int[] ans = new int[A.length];
        Arrays.fill(ans, -1); //-1 when that elem itself is the smallest

        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.empty() && A[stack.peek()] > A[i]) {//A[i] will be prev smaller for all elements greater than A[i]
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
