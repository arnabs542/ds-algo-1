package com.dsa.algorithm.string.leetcode;

import java.util.HashMap;

//LC #1044
public class LongestDuplicateSubstring {

    public String longestDupSubstring(String s) {

        int startIndex = -1;
        int length = 0;

        int l = 1;
        int r = s.length();

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int index = checkForDuplicateSubstring(mid, s);
            if (index > -1) { //duplicate substring of length mid exists starting at index startIndex
                l = mid + 1;
                startIndex = index;
                length = mid;
            } else {
                r = mid - 1;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + length);
    }

    private int checkForDuplicateSubstring(int length, String s) {

        int a = 26;
        int mod = (1 << 31) - 1;

        long hash = 0l;
        long base = 1l;
        for (int i = length - 1; i >= 0; i--) {
            long curr = ((base * a) % mod * (s.charAt(i) - 'a') % mod) % mod;
            hash = (hash + curr) % mod;
            base = (base * a) % mod;
        }

        //key: hash value, value: startIndex
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);

        for (int i = 1; i < s.length() - length + 1; i++) {

            hash = (hash - ((s.charAt(i - 1) - 'a') * base) % mod + mod) % mod;
            hash += (s.charAt(i + length - 1) - 'a') % mod;
            hash = (hash * a) % mod;

            int startIndex = map.getOrDefault(hash, -1);
            if (startIndex != -1) {
                if (verify(startIndex, i, length, s)) {
                    return startIndex;
                }
            } else {
                map.put(hash, i);
            }
        }
        return -1;
    }

    private boolean verify(int startIndex1, int startIndex2, int length, String s) {

        for (int i = 0; i < length; i++) {
            if (s.charAt(startIndex1++) != s.charAt(startIndex2++)) {
                return false;
            }
        }
        return true;
    }
}
