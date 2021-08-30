package com.dsa.sorting.ii;

import java.util.HashMap;
import java.util.Map;

public class GameOfBottles {
    public int solve(int[] A) {

        // volume of jug that occurs max no. of times will be the answer
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}

