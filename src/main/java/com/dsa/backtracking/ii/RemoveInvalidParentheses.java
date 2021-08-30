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


