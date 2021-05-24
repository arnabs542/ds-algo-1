package com.graphs.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MakeCircle {

    boolean[] visited = new boolean[26];

    public int solve(String[] A) {

        HashMap<Character, ArrayList<Character>> outMap = new HashMap<>(); //to store out-degree of nodes
        HashMap<Character, ArrayList<Character>> inMap = new HashMap<>(); //to store in-degree of nodes

        //edge represents one word, vertices can be shared
        for (int i = 0; i < A.length; i++) {
            ArrayList<Character> nbr = outMap.getOrDefault(A[i].charAt(0), new ArrayList<>());
            nbr.add(A[i].charAt(A[i].length() - 1));
            outMap.put(A[i].charAt(0), nbr);

            nbr = inMap.getOrDefault(A[i].charAt(A[i].length() - 1), new ArrayList<>());
            nbr.add(A[i].charAt(0));
            inMap.put(A[i].charAt(A[i].length() - 1), nbr);
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!visited[A[i].charAt(0) - 'a']) { //do dfs on all 1's, separate islands will be counted
                count++;
                if (count > 1) { //if disconnected components, then not possible to form circle
                    return 0;
                }
                dfs(A[i].charAt(0), outMap);
            }
        }

        //if in-degree and out-degree of every node is same, then possible to make circle
        for (Map.Entry<Character, ArrayList<Character>> entry : outMap.entrySet()) {
            if (entry.getValue().size() != inMap.getOrDefault(entry.getKey(), new ArrayList<>()).size()) {
                return 0;
            }
        }
        return 1;
    }

    // DFS
    private void dfs(Character c, HashMap<Character, ArrayList<Character>> outMap) {
        visited[c - 'a'] = true;
        for (Character ch : outMap.getOrDefault(c, new ArrayList<>())) {
            if (!visited[ch - 'a']) {
                dfs(ch, outMap);
            }
        }
    }
}

/*

Make Circle
Problem Description

Given an array of strings A of size N, find if the given strings can be chained to form a circle.

A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

NOTE: All strings consist of lower case characters.



Problem Constraints
1 <= N <= 105

Sum of length of all strings <= 106



Input Format
First and only argument is a string array A of size N.



Output Format
Return an integer 1 if it is possible to chain the strings to form a circle else return 0.



Example Input
Input 1:

 A = ["aab", "bac", "aaa", "cda"]
Input 2:

 A = ["abc", "cbc"]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can chain the strings aab -> bac -> cda -> aaa -> aab. So this forms a circle. So, output will be 1.
Explanation 2:

 There is no way to chain the given strings such that they forms a circle.
 */