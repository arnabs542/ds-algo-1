package com.dsa.backtracking.ii;

import java.util.ArrayList;

public class PalindromePartitioning {

    private ArrayList<ArrayList<String>> ans;

    public ArrayList<ArrayList<String>> partition(String a) {
        ans = new ArrayList<>();
        placePartition(0, 0, a, new ArrayList<>());
        return ans;
    }

    private void placePartition(int lastPartitionIndex, int currentIndex, String a,
                                ArrayList<String> currPalindromeSet) {

        //only when lastPartitionIndex reaches end we have palindromes
        if (lastPartitionIndex == a.length()) {
            ans.add(new ArrayList<>(currPalindromeSet));
            return;
        }

        if (currentIndex == a.length()) {
            return;
        }

        String sub = a.substring(lastPartitionIndex, currentIndex + 1);

        //place partition if palindrome till currentIndex
        if (checkPalindrome(sub)) {
            currPalindromeSet.add(sub);
            placePartition(currentIndex + 1, currentIndex + 1, a, currPalindromeSet);
            currPalindromeSet.remove(currPalindromeSet.size() - 1); //backtracking
        }

        //don't place partition, we can choose not to place partition even if palindrome found
        placePartition(lastPartitionIndex, currentIndex + 1, a, currPalindromeSet);
    }

    //checks if a string is palindrome
    private boolean checkPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
