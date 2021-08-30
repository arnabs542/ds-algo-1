package com.dsa.hashing.i;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {

        int[] countOfChars = new int[256]; //store count of each character so far
        int maxSoFar = 0; //length of longest substring so far

        int j = 0; //left pointer
        for (int i = 0; i < A.length(); i++) {
            countOfChars[A.charAt(i)]++;

            while (countOfChars[A.charAt(i)] > 1) {
                countOfChars[A.charAt(j)]--;
                j++; //if substring between j and i+1 does not have distinct chars, increment left pointer
            }   
            maxSoFar = Math.max(maxSoFar, i - j + 1);
        }
        return maxSoFar;
    }
}
