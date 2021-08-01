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
/*
Palindrome Partitioning
Problem Description

Given a string A, partition A such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of A.

Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))


Problem Constraints
1 <= len(A) <= 15



Input Format
First argument is a string A of lowercase characters.



Output Format
Return a list of all possible palindrome partitioning of s.



Example Input
Input 1:

A = "aab"
Input 2:

A = "a"


Example Output
Output 1:

 [
    ["a","a","b"]
    ["aa","b"],
  ]
Output 2:

 [
    ["a"]
  ]


Example Explanation
Explanation 1:

In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
Explanation 2:

In the given example, only partition possible is "a" .

 */