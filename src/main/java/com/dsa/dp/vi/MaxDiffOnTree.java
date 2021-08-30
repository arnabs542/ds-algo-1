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
