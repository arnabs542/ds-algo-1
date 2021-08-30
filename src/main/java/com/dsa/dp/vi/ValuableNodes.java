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

