package com.dsa.tries;

public class MaximumXOR {

    public int solve(int[] A) {

        int ans = 0;

        TrieNode root = new TrieNode();
        insert(A[0], root);

        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, maxXor(root, A[i]));
            insert(A[i], root);
        }
        return ans;
    }

    private int maxXor(TrieNode root, int A) {
        TrieNode curr = root;
        int no = 0;

        //if bit is 1, to maximize XOR we need 0, so search if it exists else take whatever is there
        for (int j = 30; j >= 0; j--) {

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

    // insert a number into trie
    private void insert(int N, TrieNode root) {

        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {

            int bit = ((N & (1 << i)) > 0) ? 1 : 0;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
    }

}
