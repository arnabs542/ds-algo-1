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

/*

First Depth First Search
Problem Description

You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i.

NOTE: Array A is 0-indexed.



Problem Constraints
1 <= n <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */