package com.dsa.algorithm.string;

public class ClosestPalindrome {
    public String solve(String A) {

        int count = 0;
        int i = 0;
        int j = A.length() - 1;

        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                count++;
                if (count > 1) { //if # of char not matching are more than 1, not possible to get palindrome by changing just one char
                    return "NO";
                }
            }
            i++;
            j--;
        }
        return (count == 0 && A.length() % 2 == 0) ? "NO" : "YES"; //if even length string is already palindrome, not possible else possible
    }
}

