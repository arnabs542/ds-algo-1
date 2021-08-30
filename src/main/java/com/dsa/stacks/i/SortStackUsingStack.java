package com.dsa.stacks.i;

import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingStack {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Stack<Integer> stack = new Stack<>(); //stack that will have sorted integers

        int top = A.size() - 1; //index pointing to top of input stack

        while (top > -1) {
            int currVal = A.get(top); //current elem of input stack
            while (!stack.empty() && (stack.peek() > currVal)) { //if output stack top elem > incoming element, pop and push to input stack
                A.set(top++, stack.pop());
            }
            stack.push(currVal); //push curr elem to output stack
            top--;
        }
        return new ArrayList<>(stack);
    }
}
