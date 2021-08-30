package com.dsa.hashing.ii;

public class ReplicatingSubstring {
    public int solve(int A, String B) {

        if (B.length() % A != 0) { //if String B cannot be equally divided into A groups
            return -1;
        }
        int[] count = new int[26]; //count of each character
        for (int i = 0; i < B.length(); i++) {
            count[B.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] % A != 0) { //if character cannot be distributed into A groups
                return -1;
            }
        }
        return 1;
    }
}

