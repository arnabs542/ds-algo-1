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
/*
Redundant Braces
Problem Description

Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Check whether A has redundant braces or not.

NOTE: A will be always a valid expression.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if A has redundant braces, else return 0.



Example Input
Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.


 */