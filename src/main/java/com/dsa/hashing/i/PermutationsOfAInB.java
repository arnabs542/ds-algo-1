package com.dsa.hashing.i;

public class PermutationsOfAInB {
    public int solve(String A, String B) {

        if (A.length() > B.length()) {
            return 0;
        }
        int[] countA = new int[26];
        int[] countB = new int[26];

        //count of chars in A
        for (int i = 0; i < A.length(); i++) {
            countA[A.charAt(i) - 'a']++;
        }
        //count of chars in B in first window of size A.length()
        for (int i = 0; i < A.length(); i++) {
            countB[B.charAt(i) - 'a']++;
        }

        int ans = checkIfSubstringIsPermutation(countA, countB); //check first window

        //check each count sized window, if its a permutation
        for (int i = 0, j = A.length(); j < B.length(); i++, j++) {
            countB[B.charAt(j) - 'a']++; //new character coming in at j
            countB[B.charAt(i) - 'a']--; //prev character moving out from window

            ans += checkIfSubstringIsPermutation(countA, countB); //current window starts at i+1
        }
        return ans;
    }

    //returns 1 if substring is a permutation
    private int checkIfSubstringIsPermutation(int[] countA, int[] countB) {
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                return 0;
            }
        }
        return 1;
    }
}
