package com.dsa.algorithm.string;

public class SmallestPrefixString {
    public String smallestPrefix(String A, String B) {
        int i = 1; //need to include atleast first char from A
        for (; i < A.length(); i++) {
            if (A.charAt(i) >= B.charAt(0)) { //break when we encounter char in A >= first char in B, to get lexicographically smallest
                break;
            }
        }
        return A.substring(0, i) + B.charAt(0);
    }
}
