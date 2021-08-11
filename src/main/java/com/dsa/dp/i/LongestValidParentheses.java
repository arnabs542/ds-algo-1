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
/*
Longest Balanced Substring
Problem Description

Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string .

Conditions for a string to be balanced :

Blank string is balanced ( However blank string will not be provided as a test case ).
If B is balanced : (B) , [B] and {B} are also balanced.
If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced.


Problem Constraints
0 <= |A| <= 106



Input Format
First and only argument is an string A.



Output Format
Return an single integer denoting the length of the longest balanced substring.



Example Input
Input 1:

 A = "[()]"
Input 2:

 A = "[(])"


Example Output
Output 1:

 4
Output 2:

 0


Example Explanation
Explanation 1:

 Substring [1:4] i.e "[()]" is the longest balanced substring of length 4.
Explanation 2:

 None of the substring is balanced so answer is 0.

 */