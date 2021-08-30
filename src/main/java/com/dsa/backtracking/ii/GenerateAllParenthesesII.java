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

