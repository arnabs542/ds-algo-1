package com.dsa.graphs.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class FirstDFS {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {

        if (B == C) {
            return 1;
        }

        //create adjacency map
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> nbr = adjMap.getOrDefault(A.get(i), new ArrayList<>());
            nbr.add(i + 1);
            adjMap.put(A.get(i), nbr);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(C); //start DFS from C

        //iterative DFS
        while (!stack.empty()) {

            Integer currNode = stack.pop();
            ArrayList<Integer> nbr = adjMap.getOrDefault(currNode, new ArrayList<>());

            for (int i = 0; i < nbr.size(); i++) {
                if (nbr.get(i) == B) {
                    return 1;
                } else {
                    stack.push(nbr.get(i));
                }
            }
        }
        return 0;
    }
}

