package com.dsa.dp.vi;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxDiffOnTree {
    private final HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private final HashMap<Integer, Pair<Integer, Integer>> dp = new HashMap<>(); //for memoization

    private int ans = Integer.MIN_VALUE;

    public int solve(int[] A, int[][] B) {

        //store all edges in map, both ways
        for (int i = 0; i < B.length; i++) {

            ArrayList<Integer> val = map.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);
            map.put(B[i][0], val);

            val = map.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);
            map.put(B[i][1], val);
        }

        recurse(1, 0, A);
        return ans;
    }

    private Pair<Integer, Integer> recurse(int nodeNo, int parentNodeNo, int[] A) {

        if (dp.get(nodeNo) != null) { //if already calculated
            return dp.get(nodeNo);
        }

        ArrayList<Integer> val = map.getOrDefault(nodeNo, new ArrayList<>());

        int max = A[nodeNo - 1]; //current Node itself is booth min and max
        int min = A[nodeNo - 1];

        //check all children
        for (int i = 0; i < val.size(); i++) {

            if (val.get(i).equals(parentNodeNo))
                continue;

            Pair<Integer, Integer> temp = recurse(val.get(i), nodeNo, A);
            max = Math.max(max, temp.max);
            min = Math.min(min, temp.min);
        }
        ans = Math.max(ans, Math.max(Math.abs(A[nodeNo - 1] - min), Math.abs(A[nodeNo - 1] - max))); //update ans

        dp.put(nodeNo, new Pair<>(Math.min(A[nodeNo - 1], min), Math.max(A[nodeNo - 1], max))); //update memoization hashmap

        return new Pair<>(Math.min(A[nodeNo - 1], min), Math.max(A[nodeNo - 1], max));
    }

    static class Pair<T, U> {
        T min;
        U max;

        public Pair(T min, U max) {
            this.min = min;
            this.max = max;
        }
    }
}
/*
Maximum Difference on Tree
Problem Description

Given a tree with N nodes labeled from 1 to N.

Each node has a certain weight assigned to it given by an integer array A of size N.

Your task is to find the maximum difference in weights of two nodes where one node is a descendant of the other.

NOTE:

The tree is rooted at node labeled with 1.


Problem Constraints
2 <= N <= 105

-103 <= A[i] <= 103



Input Format
First argument is an integer array A of size N denoting the weight of each node.

Second argument is a 2-D array B of size (N-1) x 2 denoting the edge of the tree.



Output Format
Return an single integer denoting the maximum difference in weights of two nodes where one node is a descendant of the other.



Example Input
Input 1:

 A = [10, 5, 12, 6]
 B = [  [1, 2]
        [1, 4]
        [4, 3]
     ]
Input 2:

 A = [11, 12]
 B = [  [1, 2]
     ]


Example Output
Output 1:

 6
Output 2:

 1


Example Explanation
Explanation 1:

 The maximum difference occurs between the 3rd and 4th nodes. A[3] − A[4] = 12 - 6 = 6 .
Explanation 2:

 The maximum difference occurs between the 2nd and 1st nodes. A[2] − A[1] = 12 - 11 = 1 .

 */