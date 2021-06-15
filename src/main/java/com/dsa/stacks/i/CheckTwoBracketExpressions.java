package com.dsa.stacks.i;

import java.util.Stack;

public class CheckTwoBracketExpressions {

    private Stack<Integer> sign;
    private int[] count;

    public int solve(String A, String B) {

        count = new int[26];

        sign = new Stack<>();
        sign.push(1);

        evaluate(A, 1); //evaluate sign of chars in A normally
        evaluate(B, -1); //evaluate sign of chars in B by negating
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) { //if overall count not 0, means different expressions
                return 0;
            }
        }
        return 1;
    }

    private void evaluate(String A, int negate) {

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '+' || A.charAt(i) == '-') {
                continue;
            } else if (A.charAt(i) == '(') { //on new opening, globalSign will change, push new globalSign to stack
                int prevGlobalSign = sign.peek();
                int localSign = getSign(A, i);
                sign.push(prevGlobalSign * localSign);
            } else if (A.charAt(i) == ')') {
                sign.pop();
            } else {
                int localSign = getSign(A, i);
                int currentGlobalSign = sign.peek(); //check globalSign
                count[A.charAt(i) - 'a'] += localSign * currentGlobalSign * negate;
            }
        }
    }

    //1 for + and -1 for -
    private int getSign(String A, int i) {
        if (i > 0 && A.charAt(i - 1) == '-') {
            return -1;
        }
        return 1;
    }
}
/*
Check two bracket expressions
Problem Description

Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.



Problem Constraints
1 <= length of the each String <= 100



Input Format
The arguments given are string A and String B.



Output Format
Return 1 if they represent the same expression else return 0.



Example Input
Input 1:

 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:

 A = "a-b-(c-d)"
 B = "a-b-c-d"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
Explanation 2:

 Both the expression are different.
 */