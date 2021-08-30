package com.dsa.stacks.i;

import java.util.Stack;

public class BalancedParanthesis {
    public int solve(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return 0;
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
