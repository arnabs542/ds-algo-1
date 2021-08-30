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
