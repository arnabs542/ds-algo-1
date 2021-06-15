package com.dsa.algorithm.string;

public class MakeStringPalindrome {
    public int solve(String A) {

        StringBuilder rev = new StringBuilder(A);
        StringBuilder original = new StringBuilder(A);
        original.append(rev.reverse()); // A appended with reverse of A

        int[] Z = getZArray(original.toString());

        for (int i = Z.length / 2; i < Z.length; i++) {
            if (Z[i] == Z.length - i) {//prefix that lasts till end starting at i
                return A.length() - Z[i];
            }
        }
        return 0;
    }

    //O(n)
    private int[] getZArray(String s) {

        int n = s.length();
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]); //i - l corresponds to position of char same as that at i
            } else {
                int j = 0;
                while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                    j++;
                }
                z[i] = j;
                l = i;
                r = i + j - 1;
            }
        }
        return z;
    }

    //O(n^2)
    private int[] getZArray1(String s) {

        int n = s.length();
        int[] z = new int[n];

        for (int i = 1; i < n; i++) {
            int j = 0;
            while ((i + j < n) && s.charAt(i + j) == s.charAt(j)) {
                z[i]++;
                j++;
            }
        }
        return z;
    }
}
/*
Make String Pallindrome
Problem Description

Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints
1 <= N <= 106



Input Format
The only argument given is a string A.



Output Format
Return an integer denoting the minimum characters that are needed to be inserted to make the string a palindrome string.



Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome.

 */