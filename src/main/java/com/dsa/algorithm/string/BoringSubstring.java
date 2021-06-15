package com.dsa.algorithm.string;

import java.util.Arrays;

public class BoringSubstring {
    public int solve(String A) {

        StringBuffer even = new StringBuffer(); //contains chars having ascii value even
        StringBuffer odd = new StringBuffer(); //contains chars having ascii value odd

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) % 2 == 0) {
                even.append(A.charAt(i));
            } else {
                odd.append(A.charAt(i));
            }
        }
        char[] e = even.toString().toCharArray();
        char[] o = odd.toString().toCharArray();
        Arrays.sort(e); //sort even string
        Arrays.sort(o); //sort odd string

        String es = new String(e);
        String os = new String(o);

        if (check(es + os) || check(os + es)) { //check if either of o+e or e+o is valid
            return 1;
        }
        return 0;
    }

    //checks if any two consecutive chars in s are neighbours
    private boolean check(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) == 1) {
                return false;
            }
        }
        return true;
    }
}
/*
Boring substring
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input
Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac"
Explanation 2:

 No arrangement of string A can make it free of boring substrings.

 */