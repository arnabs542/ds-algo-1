package com.dsa.stacks.ii;

import java.util.ArrayList;

public class ReverseStackUsingRecursion {

    private ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        reverseStack(A, A.size() - 1);
        return ans;
    }

    private void reverseStack(ArrayList<Integer> A, int index) {
        if (index < 0) {
            return;
        }
        ans.add(A.get(index)); //add to ans
        reverseStack(A, index - 1); //recurse
    }
}
