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
