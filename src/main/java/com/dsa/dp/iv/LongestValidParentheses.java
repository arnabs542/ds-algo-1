package com.dsa.dp.iv;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String A) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //when stack is empty we should get length of string till that i i.e i+1

        int ans = 0;
        for (int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == '(') {  //push any opening brace
                stack.push(i);

            } else if (stack.peek() != -1 && A.charAt(i) == ')' && A.charAt(stack.peek()) == '(') { //if top of stack has corresponding opening

                stack.pop(); //pop first, eg: (()() this case will give ans 1 if we dont pop first, but ans has to be 4
                ans = Math.max(ans, i - stack.peek()); //update global ans

            } else { //push any inappropriate brace
                stack.push(i);
            }
        }
        return ans;
    }
}
/*
Longest valid Parentheses
Problem Description

Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.



Problem Constraints
1 <= length(A) <= 750000



Input Format
The only argument given is string A.



Output Format
Return the length of the longest valid (well-formed) parentheses substring.



Example Input
Input 1:

 A = "(()"
Input 2:

 A = ")()())"


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 The longest valid parentheses substring is "()", which has length = 2.
Explanation 2:

 The longest valid parentheses substring is "()()", which has length = 4.

 */
