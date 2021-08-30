package com.dsa.stacks.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RedundantBraces {
    public int braces(String A) {

        ArrayList<Character> operators = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            boolean operatorFound = false;

            if (A.charAt(i) == ')') {
                while (stack.peek() != '(') { //pop all characters that are not '('
                    if (operators.contains(stack.pop())) {
                        operatorFound = true;
                    }
                }
                stack.pop(); //pop out '('
                if (!operatorFound) { //if no operator found even after popping operands/operators, then redundant expression
                    return 1;
                }
            } else { //push every other character
                stack.push(A.charAt(i));
            }
        }
        return 0;
    }
}
