package com.dsa.dp.vi;

import java.util.ArrayList;
import java.util.HashMap;

public class ValuableNodes {

    //node to its great grandchildren mapping
    private final HashMap<Integer, ArrayList<Integer>> ggcMap = new HashMap<>();

    //node to its great grandchildren mapping
    private final HashMap<Integer, ArrayList<Integer>> cMap = new HashMap<>();

    //node to its answer mapping for memoization
    private final HashMap<Integer, Integer> dp = new HashMap<>();

    private final int mod = 1000000007;

    public int solve(int[] A, int[] B) {

        // A[i] denotes parent of i+1
        // A[A[i]-1] denotes grandparent of i+1
        // A[A[A[i]-1]-1] denotes great grandparent of i+1
        for (int i = 0; i < A.length; i++) {

            //put all ggc's in map
            if (A[i] - 1 >= 0 && A[A[i] - 1] - 1 >= 0) {
                ArrayList<Integer> ggc = ggcMap.getOrDefault(A[A[A[i] - 1] - 1], new ArrayList<>());
                ggc.add(i + 1);
                ggcMap.put(A[A[A[i] - 1] - 1], ggc);
            }

            //put all children in map
            ArrayList<Integer> c = cMap.getOrDefault(A[i], new ArrayList<>());
            c.add(i + 1);
            cMap.put(A[i], c);

        }
        return recurse(1, B);
    }

    //returns the max sum of tree rooted at nodeNo
    private int recurse(int nodeNo, int[] B) {

        if (dp.get(nodeNo) != null) {
            return dp.get(nodeNo);
        }

        int excludeAns = 0; //exclude current node and check all its children
        for (Integer child : cMap.getOrDefault(nodeNo, new ArrayList<>())) {
            excludeAns = (excludeAns + recurse(child, B)) % mod;
        }

        int includeAns = 0; //include current node and check all its great grandchildren
        for (Integer ggChild : ggcMap.getOrDefault(nodeNo, new ArrayList<>())) {
            includeAns = (includeAns + recurse(ggChild, B)) % mod;
        }

        int ans = Math.max((includeAns + B[nodeNo - 1]) % mod, excludeAns); //ans for currentNode
        dp.put(nodeNo, ans); //update dp map

        return ans;
    }
}
/*
Valuable Nodes
Problem Description

Given a tree T containing N nodes numbered [1,2, ..., N] rooted at node 1.

Each node has a value associated with it. You need to choose some of the nodes from the tree such that the sum of values of the chosen nodes is maximum possible.

Moreover, if you have chosen a node V you cannot choose any of its children or grand children.

In simple words, you have to choose a subset of nodes such that no two nodes in the chosen set have a parent-child relation or grandfather-grandchild relation between them.



Problem Constraints
1 <= N <= 500000

1 <= val <= 10000



Input Format
First argument is the vector A, where A[i] denotes parent of i+1

Second argument is the vector B, where B[i] if the value associated with node i+1



Output Format
Return an integer containing the maximum possible sum. (As the answer can be large, output the answer modulo 1000000007)



Example Input
Input 1:

A = [0]
B = [1]
Input 2:

A = [0, 1, 2, 3]
B = [1, 50, 3, 4]


Example Output
Output 1:

 1
Output 2:

 50


Example Explanation
Explanation 1:

 Only node 1 is taken.
Explanation 2:

 Only node 2 is taken.

 */
