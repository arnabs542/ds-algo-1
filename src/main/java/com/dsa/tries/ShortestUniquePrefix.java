package com.dsa.tries;

public class ShortestUniquePrefix {

    public String[] prefix(String[] A) {

        TrieNode root = new TrieNode();
        root.freq = 0;

        //insert all words into trie
        for (String s : A) {
            insert(s, root);
        }

        String[] ans = new String[A.length];

        for (int i = 0; i < A.length; i++) {

            StringBuilder s = new StringBuilder();

            TrieNode curr = root;
            //Traverse trie and check for freq == 1
            for (int j = 0; j < A[i].length(); j++) {
                Character ch = A[i].charAt(j);
                int index = ch - 'a';
                s.append(ch);

                if (curr.children[index].freq == 1) { //if freq is one, we have found unique prefix for the word
                    ans[i] = s.toString();
                    break;
                }
                curr = curr.children[index]; //traverse the trie further
            }
        }
        return ans;
    }

    // insert a word into trie
    private void insert(String s, TrieNode root) {

        TrieNode curr = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {//create new node with freq = 1
                curr.children[index] = new TrieNode();
            } else {
                curr.children[index].freq++; //increase freq
            }
            curr = curr.children[index]; //traverse the trie further
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; //all possible chars
        int freq = 1; //freq of node
    }
}

