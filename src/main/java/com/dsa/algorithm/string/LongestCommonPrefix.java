package com.dsa.algorithm.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}

