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
/*
Evaluate Expression
Problem Description

An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is character array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
    9
Output 2:
    6


Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6

 */