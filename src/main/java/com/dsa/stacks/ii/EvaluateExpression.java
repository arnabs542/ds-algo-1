package com.dsa.stacks.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(String[] A) {

        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));
        Stack<String> stack = new Stack<>();

        //if operator encountered, pop top two values and perform arithmetic operation and push result to stack
        for (int i = 0; i < A.length; i++) {
            String c = A[i];
            if (operators.contains(c)) {
                int int1 = Integer.parseInt(stack.pop());
                int int2 = Integer.parseInt(stack.pop());

                int operatorIndex = operators.indexOf(c);

                int val;
                if (operatorIndex == 0) {
                    val = int2 + int1;
                } else if (operatorIndex == 1) {
                    val = int2 - int1;
                } else if (operatorIndex == 2) {
                    val = int2 / int1;
                } else {
                    val = int2 * int1;
                }
                stack.push(String.valueOf(val));
            } else {
                stack.push(c);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
