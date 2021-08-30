package com.dsa.dp.vii;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    private Map<String, Boolean> map; //memoization

    public int isScramble(final String A, final String B) {
        map = new HashMap<>();
        return solve(A, B) ? 1 : 0;
    }

    private boolean solve(String A, String B) {

        String key = A + "_" + B;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (A.equalsIgnoreCase(B) || (A.length() == 0 && B.length() == 0)) {
            map.put(key, true);
            return true;
        }
        if (A.length() <= 1 || A.length() != B.length()) {
            map.put(key, false);
            return false;
        }

        int n = A.length();
        for (int k = 1; k <= n - 1; k++) {
            //when not swapping
            boolean one = solve(A.substring(0, k), B.substring(0, k));
            boolean two = solve(A.substring(k), B.substring(k));

            if (one && two) {
                map.put(key, true);
                return true;
            }
            //when swapping
            boolean three = solve(A.substring(0, k), B.substring(n - k));
            boolean four = solve(A.substring(k), B.substring(0, n - k));

            if (three && four) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
