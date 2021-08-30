package com.dsa.stacks.i;

import java.util.Stack;

public class MinStack {

    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    private int minSoFar = Integer.MAX_VALUE;

    public void push(int x) {
        if (stack.empty()) {
            minSoFar = Integer.MAX_VALUE; //when stack is empty, reset minSoFar
        }
        minSoFar = Math.min(minSoFar, x);
        stack.push(new Pair(x, minSoFar)); //push elem along with minSoFar
    }

    public void pop() {
        if (!stack.empty()) {
            stack.pop();
            if (!stack.empty()) {
                minSoFar = stack.peek().minSoFar; //when popping elem, update minSoFar
            }
        }
    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek().value;
    }

    public int getMin() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek().minSoFar;
    }

    static class Pair<T, U> {
        T value;
        U minSoFar;

        public Pair(T value, U minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }
    }
}
//Best approach

//class MinStack {
//
//    private long globalMin;
//    Stack<Long> stack;
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        stack = new Stack<>();
//        globalMin = 2147483648L;
//    }
//
//    public void push(int val) {
//        if (!stack.empty() && globalMin > val) {
//            long currMin = globalMin;
//            globalMin = Long.valueOf(val);
//            stack.push(2L * Long.valueOf(val) - currMin);
//        } else {
//            globalMin = Math.min(globalMin, Long.valueOf(val));
//            stack.push(Long.valueOf(val));
//        }
//    }
//
//    public void pop() {
//        long poppedVal = stack.pop();
//        if (poppedVal < globalMin) {
//            globalMin = 2L * globalMin - poppedVal;
//        }
//        if (stack.empty()) {
//            stack = new Stack<>();
//            globalMin = 2147483648L;
//        }
//    }
//
//    public int top() {
//        long poppedVal = stack.peek();
//        long actualVal = poppedVal;
//        if (poppedVal < globalMin) {
//            actualVal = globalMin;
//        }
//        return (int) actualVal;
//    }
//
//    public int getMin() {
//        return (int) globalMin;
//    }
//}