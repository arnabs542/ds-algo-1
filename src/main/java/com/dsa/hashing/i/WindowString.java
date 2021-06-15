package com.dsa.hashing.i;

public class WindowString {
    public String minWindow(String A, String B) {

        int[] a = new int[256]; //counts of each char in A
        int[] b = new int[256]; //counts of each char in B
        for (int i = 0; i < B.length(); i++) {
            b[B.charAt(i)]++;
        }

        int minSoFar = Integer.MAX_VALUE; //length of shortest substring so far
        int start = -1; //start index of the substring
        int end = -1; //end index of the substring

        int count = 0; //count of chars in B, that have come in A so far
        int j = 0; //left pointer
        int i = 0; //right pointer

        //1. Use two pointers: start and end to represent a window.
        //2. Move end to find a valid window.
        //3. When a valid window is found, move start to find a smaller window.
        for (; i < A.length(); i++) {
            char ch = A.charAt(i);
            a[ch]++;

            if (a[ch] <= b[ch]) { //count of char at i in A <= that in B
                count++;
            }

            if (count == B.length()) { //count == length of B, substring is of interest to us
                //remove unnecessary characters from left
                //if char at j is (not in B or occurs more in B), it can be removed
                while ((b[A.charAt(j)] == 0) || (a[A.charAt(j)] > b[A.charAt(j)])) {
                    a[A.charAt(j)]--;
                    j++;
                }
                //after removing unnecessary characters, update length of shortest substring so far
                if (minSoFar > i - j + 1) {
                    minSoFar = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return (start == -1) ? "" : A.substring(start, end + 1);
    }
}
/*
Window String
Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )


Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.

 */