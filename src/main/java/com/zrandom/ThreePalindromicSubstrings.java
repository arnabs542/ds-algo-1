package com.zrandom;

import java.util.ArrayList;
import java.util.List;

public class ThreePalindromicSubstrings {

    public static int findMaxTrie(int[] array) {
        TrieNode root = new TrieNode();
        insert(array[0], root);

        int max = array[0];
        int curr = array[0];

        for (int i = 1; i < array.length; i++) {

            curr ^= array[i];

            TrieNode present = root;
            int x = 0;

            for (int j = 30; j >= 0; j--) {
                if (((curr >> j) & 1) == 1) {
                    if (present.children[0] != null) {
                        present = present.children[0];
                    } else {
                        x |= (1 << j);
                        present = present.children[1];
                    }
                } else {
                    if (present.children[1] != null) {
                        x |= (1 << j);
                        present = present.children[1];
                    } else {
                        present = present.children[0];
                    }
                }
            }
            max = Math.max(max, x ^ curr);
            insert(curr, root);
        }
        return max;
    }

    // insert a number into trie
    private static void insert(int N, TrieNode root) {

        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {

            int bit = ((N & (1 << i)) > 0) ? 1 : 0;

            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    public static List<String> threePalindromicSubstrings(String A) {

        int n = A.length();

        boolean[][] pal = new boolean[n][n]; //pal[i][j] stores whether A.subString(i,j+1) is palindrome
        for (int i = 0; i < n; i++)
            pal[i][i] = true; //single char is a palindrome
        for (int i = 0; i < n - 1; i++) //check for strings of length 2
            if (A.charAt(i) == A.charAt(i + 1))
                pal[i][i + 1] = true;
        for (int len = 3; len <= n; len++) {//for each length
            for (int i = 0; i + len - 1 < n; i++) { //fix i
                int j = i + len - 1; //fix j
                if (A.charAt(i) == A.charAt(j))
                    pal[i][j] = pal[i + 1][j - 1];
            }
        }

        boolean[][] dp = new boolean[n + 1][4]; //dp[i][j] is true if suffix string from i can be divided into j palindromic parts
        dp[n][0] = true;

        for (int j = 1; j <= 3; j++)
            for (int i = n - 1; i >= 0; i--)
                for (int k = i; k < n; k++)
                    if (pal[i][k] && dp[k + 1][j - 1])
                        dp[i][j] = true;


        List<String> ans = new ArrayList<>();
        if (dp[0][3]) {
            int firstSplitIndex = -1;
            for (int i = 1; i < dp.length; i++) {
                if (dp[i][2] && pal[0][i - 1]) {
                    firstSplitIndex = i;
                    ans.add(A.substring(0, firstSplitIndex));
                    break;
                }
            }
            for (int i = firstSplitIndex + 1; i < dp.length; i++) {
                if (dp[i][1] && pal[firstSplitIndex][i - 1]) {
                    ans.add(A.substring(firstSplitIndex, i));
                    ans.add(A.substring(i, n));
                    break;
                }
            }
        } else {
            ans.add("IMPOSSIBLE");
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = threePalindromicSubstrings("hhhiggxc");
        System.out.println(ans.toString());
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; //all possible chars
    }
}