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
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */

/*
Min Stack
Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:

All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.


Problem Constraints
1 <= Number of Function calls <= 107



Input Format
Functions will be called by the checker code automatically.



Output Format
Each function should return the values as defined by the problem statement.



Example Input
Input 1:

push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()
Input 2:

getMin()
pop()
top()


Example Output
Output 1:

 -2 1 2
Output 2:

 -1 -1


Example Explanation
Explanation 1:

Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.
Explanation 2:

Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.
 */