package com.dsa.backtracking.ii;

import java.util.ArrayList;

public class GenerateAllParenthesesII {

    private final ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int A) {
        generate(0, 0, new StringBuilder(), A);
        return ans;
    }

    private void generate(int open, int closed, StringBuilder s, int count) {

        if (open > count || closed > count) {
            return;
        }

        if (s.length() == (2 * count)) {
            ans.add(new String(s));
            return;
        }

        //when no. of open braces less than count, we can keep another open brace
        if (open < count) {
            s.append("(");
            generate(open + 1, closed, s, count);
            s.deleteCharAt(s.length() - 1); //backtrack
        }

        //when no. of closed braces less than open count, we keep closed brace to make well formed string
        if (closed < open) {
            s.append(")");
            generate(open, closed + 1, s, count);
            s.deleteCharAt(s.length() - 1); //backtrack
        }
    }
}
/*
Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 20



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible parentheses.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All parentheses are given in the output list.
Explanation 2:

 All parentheses are given in the output list.
 */
