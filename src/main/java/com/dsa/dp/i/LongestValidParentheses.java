package com.dsa.dp.i;

import java.util.Stack;

public class LongestValidParentheses {

    public int LBSlength(final String A) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //when stack is empty we should get length of string till that i i.e i+1

        int ans = 0;

        for (int i = 0; i < A.length(); i++) {

            if (stack.peek() != -1
                    && ((A.charAt(i) == ')' && A.charAt(stack.peek()) == '(')
                    || (A.charAt(i) == ']' && A.charAt(stack.peek()) == '[')
                    || (A.charAt(i) == '}' && A.charAt(stack.peek()) == '{'))) { //if top of stack has corresponding opening

                stack.pop(); //pop first, eg: (()() this case will give ans 1 if we dont pop first, but ans has to be 4
                ans = Math.max(ans, i - stack.peek()); //update global ans
            } else { //push any inappropriate brace
                stack.push(i);
            }
        }
        return ans;
    }
}
