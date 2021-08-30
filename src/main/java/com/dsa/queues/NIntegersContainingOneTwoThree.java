package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NIntegersContainingOneTwoThree {
    public ArrayList<Integer> solve(int A) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] nos = new int[]{1, 2, 3};

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0); //add 0, to generate initial no.s 1,2 and 3

        while (ans.size() < A) {
            int currNo = deque.pollFirst(); //pop first elem
            if (currNo != 0) {
                ans.add(currNo);
            }
            for (int i = 0; i < nos.length; i++) { //generate all possible no.s with currNo
                Integer num = currNo * 10 + nos[i];
                deque.addLast(num);
            }
        }
        return ans;
    }
}
