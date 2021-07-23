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
/*
XOR Queries on Tree
Problem Description

Given a tree with A nodes and A-1 edges which is rooted at node 1.

There are C queries and for each query you are given two integers d (the node number) and e and you have to find the maximum value when e is xor’ed with any of the ancestors of d or d itself.

More formally, find the maximum value which can be obtained when e is XOR with any node in the path from d to the root.

NOTE: XOR is the bitwise XOR operator for example, 1 XOR 1 = 0 and 1 XOR 0 = 1 etc.



Problem Constraints
2 <= A <= 100000 |B| = A-1 and B[i] <= i for all i from 1 till A-1
1 <= C <= 300000
|D| = |E| = C
1 <= D[i] <= A
1 <= E[i] <= 300000



Input Format
The first argument given is the Integer A.
The second argument given is the parent array B, where B[i] denotes the parent of (i+1)'th node for all i from 1 to A-1.
Note: Size of the array B is A-1 and its indexing starts form 1.
The third argument given is the Integer C denoting the number of queries.
The fourth argument given is the array D, where D[i] denotes the value of d for the i'th query.
The fifth argument given is the array E, where E[i] denotes the value of e for the i'th query.



Output Format
Return the integer array where each index denotes the answer for every query in the same order as input.



Example Input
Input 1:

 A = 8
 B = [1, 1, 2, 2, 3, 3, 1]
 C = 5
 D = [2, 3, 5, 6, 8]
 E = [1, 1, 5, 4, 10]
Input 2:

 A = 3
 B = [1, 1]
 C = 2
 D = [2, 3]
 E = [3, 1]


Example Output
Output 1:

 [3, 2, 7, 7, 11]
Output 2:

 [2, 2]


Example Explanation
Explanation 1:

 For first query, d = 2 and e = 1, the path from 1 to 2 will be 1 -> 2, so the maximum value will be 3 i.e 1 ^ 2.
 Likewise we will get the result for all other queries.
Explanation 2:

 For first query, d = 2 and e = 3, the path from 1 to 2 will be 1 -> 2, so the maximum value will be 2 i.e 3 ^ 1.
 For second query, d = 3 and e = 1, the path from 1 to 3 will be 1 -> 3, so the maximum value will be 2 i.e 1 ^ 3.

 */