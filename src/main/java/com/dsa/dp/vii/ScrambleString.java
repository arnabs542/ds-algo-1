package com.dsa.dp.vii;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    private Map<String, Boolean> map; //memoization

    public int isScramble(final String A, final String B) {
        map = new HashMap<>();
        return solve(A, B) ? 1 : 0;
    }

    private boolean solve(String A, String B) {

        String key = A + "_" + B;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (A.equalsIgnoreCase(B) || (A.length() == 0 && B.length() == 0)) {
            map.put(key, true);
            return true;
        }
        if (A.length() <= 1 || A.length() != B.length()) {
            map.put(key, false);
            return false;
        }

        int n = A.length();
        for (int k = 1; k <= n - 1; k++) {
            //when not swapping
            boolean one = solve(A.substring(0, k), B.substring(0, k));
            boolean two = solve(A.substring(k), B.substring(k));

            if (one && two) {
                map.put(key, true);
                return true;
            }
            //when swapping
            boolean three = solve(A.substring(0, k), B.substring(n - k));
            boolean four = solve(A.substring(k), B.substring(0, n - k));

            if (three && four) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
/*
Scramble String
Problem Description

Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings A and B of the same length, determine if B is a scrambled string of S.



Problem Constraints
1 <= len(A), len(B) <= 50



Input Format
The first argument of input contains a string A.

The second argument of input contains a string B.



Output Format
Return 1 if true, 0 if false



Example Input
Input 1:

 A = "we"
 B = "we"
Input 2:

 A = "phqtrnilf"
 B = "ilthnqrpf"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:


It is the same string.


Explanation 2:

 There is no way to achieve B from A.
 */