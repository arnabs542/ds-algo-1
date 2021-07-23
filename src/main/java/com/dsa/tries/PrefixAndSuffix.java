package com.dsa.tries;

import java.util.ArrayList;

public class PrefixAndSuffix {

    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<String> filtered = new ArrayList<>();

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {

        int M = B.get(0).length();
        for (int i = 0; i < A.size(); i++) {//consider words having same prefix and suffix of length M
            if (checkPrefixSuffix(A.get(i), M)) {
                filtered.add(A.get(i));
            }
        }

        TrieNode root = new TrieNode();
        //insert filtered words into trie
        for (int i = 0; i < filtered.size(); i++) {
            insert(root, filtered.get(i));
        }
        //search in trie
        for (int i = 0; i < B.size(); i++) {
            searchPrefix(root, B.get(i));
        }
        return ans;
    }

    //checks if str has prefix and suffix of length m
    public boolean checkPrefixSuffix(String str, int m) {
        int j = str.length() - m;
        if (j < 0)
            return false;

        for (int i = 0; i < m && j < str.length(); i++, j++) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //searches for str in trie
    public void searchPrefix(TrieNode root, String str) {
        TrieNode temp = root;

        int visits = 0;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            int index = ch - 'a';
            if (temp.children[index] == null) {
                visits = 0;
                break;
            }
            visits = temp.freq;
            temp = temp.children[index];
        }
        ans.add(visits);
    }

    public void insert(TrieNode root, String str) {

        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i) - 'a';

            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            } else {
                temp.freq++;
            }
            temp = temp.children[index];
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int freq = 1;
    }
}
/*
Prefix and Suffix
Problem Description

Given a list of N words denoted by string array A of size N.

You have to answer Q queries denoted by string array B, for each query you have a string S of size M, find the number of words in the list A which have string S as a prefix and suffix.

NOTE: The size M for all strings in the queries remains same.



Problem Constraints
1 <= N <= 105

1 <= |A[i]| <= 1000

1 <= Q, M <= 1000

Sum of length of all N words <= 106



Input Format
First argument is a string array A of size N denoting the list of words.

Second argument is a string array B of size Q denoting the queries.



Output Format
Return an integer array of size Q denoting the answer of each query.



Example Input
Input 1:

 A = ["ababa", "aabbvaab", "aecdsaaec", "abaaxbqaba"]
 B = ["aba", "aec", "abb", "aab"]
Input 2:

 A = ["cazqzqcaz", "cadssac", "caz"]
 B = ["caz", "cad"]


Example Output
Output 1:

 [2, 1, 0, 1]
Output 2:

 [2, 0]


Example Explanation
Explanation 1:

 2 word "ababa" and "abaaxbqaba" has both prefix and suffix "aba".
 1 word "aecdsaaec" has both prefix and suffix "aec".
 No word has both prefix and suffix "abb".
 1 word "aabbvaab" has both prefix and suffix "aab".
Explanation 2:

 2 word "cazqzqcaz" and "caz" has both prefix and suffix "caz".
 No word has both prefix and suffix "cad".

 */