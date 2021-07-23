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
/*
Shortest Unique Prefix
Problem Description

Given a list of N words. Find shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is prefix of another. In other words, the representation is always possible



Problem Constraints
1 <= Sum of length of all words <= 106



Input Format
First and only argument is a string array of size N.



Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input
Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output
Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]


Example Explanation
Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".

Explanation 2:

 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.

 */
