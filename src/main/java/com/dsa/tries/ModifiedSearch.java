package com.dsa.tries;

import java.util.Arrays;

public class ModifiedSearch {

    public String solve(String[] A, String[] B) {

        TrieNode root = new TrieNode();

        //insert all words of array A into trie
        for (String s : A) {
            insert(s, root);
        }

        StringBuilder ans = new StringBuilder();

        for (String s : B) {
            if (traverse(root, s, 0, 0)) {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        return ans.toString();
    }

    //modified search by DFS
    private boolean traverse(TrieNode root, String str, int index, int misMatchCount) {

        //if mismatch > 1 or root is null but still some string is left to be searched, return false
        if ((misMatchCount > 1) || (root == null && index < str.length())) {
            return false;
        }
        if (str.length() == index) { //entire string got traversed
            return root.isEnd && misMatchCount == 1; //return true if root is end of the word and mismatch = 1
        }
        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {
                boolean found;

                if (str.charAt(index) - 'a' == i) { //if string's char matches one of the children, search further
                    found = traverse(root.children[i], str, index + 1, misMatchCount);
                } else { //if string's char doesn't match one of the children, search further but mismatch++
                    found = traverse(root.children[i], str, index + 1, misMatchCount + 1);
                }
                if (found)
                    return true;
            }
        }
        return false;
    }

    // insert a word into trie
    private void insert(String s, TrieNode root) {

        TrieNode curr = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index]; //traverse the trie further
        }
        curr.isEnd = true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; //all possible chars
        boolean isEnd = false;
    }
}

