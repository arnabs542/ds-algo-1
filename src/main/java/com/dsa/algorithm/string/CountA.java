package com.dsa.algorithm.string;

public class CountA {
    public int solve(String A) {

        int count = 0; //no. of a's
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                count++;
            }
        }
        return count * (count + 1) / 2; //no. of ways of choosing 2 boundaries around n elements (n+1)C2
    }
}
