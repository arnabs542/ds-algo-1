package com.dsa.backtracking.ii;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveInvalidParentheses {

    private HashSet<String> ans;//using hashset to avoid duplicates in answer

    public ArrayList<String> solve(String A) {
        ans = new HashSet<>();

        int open = 0;//store all open braces
        int closed = 0;//store only valid closed braces

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                open++;
            } else if (A.charAt(i) == ')') {
                closed++;
                closed = (closed > open) ? open : closed;//reset closed to open count when it exceeds open count
            }
        }
        //form all possible strings with valid open and closed braces
        recurse(0, closed, closed, new StringBuilder(), A);
        return new ArrayList<>(ans);
    }

    private void recurse(int currentIndex, int remOpen, int remClosed, StringBuilder s, String A) {

        if (currentIndex == A.length()) {
            if (remOpen == 0 && remClosed == 0) {//when all braces are used up, add to ans
                ans.add(s.toString());
            }
            return;
        }

        Character c = A.charAt(currentIndex);
        s = new StringBuilder(s);

        if (c == '(') {
            if (remOpen > 0) {
                s.append(c);
                recurse(currentIndex + 1, remOpen - 1, remClosed, s, A);
                s.deleteCharAt(s.length() - 1);
            }
        } else if (c == ')') {
            if (remClosed > remOpen) {
                s.append(c);
                recurse(currentIndex + 1, remOpen, remClosed - 1, s, A);
                s.deleteCharAt(s.length() - 1);
            }
        } else {
            s.append(c);
        }
        recurse(currentIndex + 1, remOpen, remClosed, s, A);
    }
}

/*
Remove Invalid Parentheses
Problem Description

Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.



Problem Constraints
1 <= length of the string <= 20



Input Format
The only argument given is string A.



Output Format
Return all possible strings after removing the minimum number of invalid parentheses.



Example Input
Input 1:

 A = "()())()"
Input 2:

 A = "(a)())()"


Example Output
Output 1:

 ["()()()", "(())()"]
Output 2:

 ["(a)()()", "(a())()"]


Example
Explanation 1:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"
Explanation 2:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"

 */
