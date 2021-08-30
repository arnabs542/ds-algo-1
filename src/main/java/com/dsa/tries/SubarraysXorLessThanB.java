package com.dsa.tries;

public class SubarraysXorLessThanB {

    private int ans = 0;
    private int mod = 1000000007;

    public int solve(int[] A, int B) {
        if (A.length == 1) {
            return A[0] >= B ? 0 : 1;
        }

        TrieNode root = new TrieNode();
        insert(0, root); //initialize trie with 0
        int prefixXOR = 0;

        for (int i = 0; i < A.length; i++) {
            prefixXOR ^= A[i];
            query(root, prefixXOR, B);
            insert(prefixXOR, root);
        }
        return (ans % mod);
    }

    private void query(TrieNode root, int prefixXOR, int B) {

        TrieNode curr = root;

        for (int i = 30; i >= 0 && curr != null; i--) {
            int bBit = (B & (1 << i)) > 0 ? 1 : 0;
            int prefixBit = (prefixXOR & (1 << i)) > 0 ? 1 : 0;

            if (bBit == 0) { // p^x = 0 means p and x have same bits, so whatever bit we had in prefixBit we want same
                curr = curr.children[prefixBit];
            } else { // p^x = 1 means p and x have diff bits, so we want opposite bit to prefixBit
                ans = (ans + (curr.children[prefixBit] != null ? curr.children[prefixBit].freq : 0)) % mod;
                curr = curr.children[1 - prefixBit];
            }
        }
    }

    // insert a number into trie
    private void insert(int N, TrieNode root) {

        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = ((N & (1 << i)) > 0) ? 1 : 0;

            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            } else {
                curr.children[bit].freq++;
            }
            curr = curr.children[bit];
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
        int freq = 1;
    }
}

