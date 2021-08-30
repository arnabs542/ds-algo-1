package com.dsa.tries;

import java.util.ArrayList;
import java.util.HashMap;

public class XORQueriesOnTree {

    //key: node no. , value: children of the node
    private HashMap<Integer, ArrayList<Integer>> nodeToChildrenMap;

    //key: d of the query, value: indices of the query
    private HashMap<Integer, ArrayList<Integer>> queryToIndicesMap;

    private int[] ans;

    public int[] solve(int A, int[] B, int C, int[] D, int[] E) {

        ans = new int[E.length];

        queryToIndicesMap = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            ArrayList<Integer> indices = queryToIndicesMap.getOrDefault(D[i], new ArrayList<>());
            indices.add(i);
            queryToIndicesMap.put(D[i], indices);
        }

        nodeToChildrenMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> children = nodeToChildrenMap.getOrDefault(B[i], new ArrayList<>());
            children.add(i + 2);
            nodeToChildrenMap.put(B[i], children);
        }

        //construct trie with only root
        TrieNode root = new TrieNode();
        root.freq = 0;

        //do DFS tree traversal starting from root
        dfsTreeTraversal(1, root, E);
        return ans;
    }

    private void dfsTreeTraversal(int nodeNo, TrieNode root, int[] E) {

        insertInTrie(root, nodeNo); //insert current node in trie

        //check if this node was asked in the queries, if yes update answer
        ArrayList<Integer> indices = queryToIndicesMap.getOrDefault(nodeNo, new ArrayList<>()); //get indices of the query
        for (int i = 0; i < indices.size(); i++) {
            int idx = indices.get(i);
            ans[idx] = maxXor(root, E[idx]);
        }

        ArrayList<Integer> children = nodeToChildrenMap.getOrDefault(nodeNo, new ArrayList<>());
        for (int i = 0; i < children.size(); i++) {
            dfsTreeTraversal(children.get(i), root, E);
        }
        //delete current node from trie, as we dealt with all its children
        deleteFromTrie(root, nodeNo);
    }

    // insert a number into trie
    private void insertInTrie(TrieNode root, int N) {

        TrieNode curr = root;
        for (int i = 16; i >= 0; i--) {

            int bit = ((N & (1 << i)) > 0) ? 1 : 0;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            } else {
                curr.children[bit].freq++;
            }
            curr = curr.children[bit];
        }
    }

    //deletes number N from trie
    private void deleteFromTrie(TrieNode root, int N) {

        TrieNode curr = root;

        for (int i = 16; i >= 0; i--) {

            int bit = ((N & (1 << i)) > 0) ? 1 : 0;

            if (curr.children[bit] != null) {
                if (curr.children[bit].freq == 1) { //freq is 1 means, all children below it represent N only, so mark it null and break
                    curr.children[bit] = null;
                    break;
                } else {
                    curr.children[bit].freq--; //we are about to remove one number, so keep decrementing the freq
                    curr = curr.children[bit];
                }
            } else { //N doesn't exist in the trie
                break;
            }
        }
    }

    //returns maxXor value possible with A and any number in trie
    private int maxXor(TrieNode root, int A) {

        TrieNode curr = root;
        int no = 0;

        //if bit is 1, to maximize XOR we need 0, so search if it exists else take whatever is there
        for (int j = 16; j >= 0; j--) {

            int bit = (A & (1 << j)) > 0 ? 1 : 0;

            if (bit == 0) {
                if (curr.children[1] != null) {
                    no += (int) Math.pow(2, j);
                    curr = curr.children[1];
                } else {
                    curr = curr.children[0];
                }
            } else {

                if (curr.children[0] != null) {
                    curr = curr.children[0];
                } else {
                    no += (int) Math.pow(2, j);
                    curr = curr.children[1];
                }
            }
        }
        return no ^ A;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
        int freq = 1;

        public TrieNode() {
        }
    }
}
