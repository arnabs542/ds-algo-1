package com.dsa.bitmanipulation;

public class InterestingArray {
    public String solve(int[] A) {
        //every even element can be made 0 by splitting it into two and xoring them
        //every odd element can be made 1 by writing it as 1 + some even no.
        //so if no. of odd elements are even then its possible
        int odd = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                odd++;
            }
        }
        return (odd % 2 == 0) ? "Yes" : "No";
    }
}
