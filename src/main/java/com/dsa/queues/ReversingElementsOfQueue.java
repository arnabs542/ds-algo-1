package com.dsa.queues;

import java.util.Stack;

public class ReversingElementsOfQueue {
    public int[] solve(int[] A, int B) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < B; i++) {//push first B elems to stack
            stack.push(A[i]);
        }
        int i = 0;
        while (!stack.empty()) {//pop stack till empty and replace array elem with top of stack
            A[i++] = stack.pop();
        }
        return A;
    }
}
