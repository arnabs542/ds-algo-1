package com.dsa.arraysNmath;

public class ReadingNewspaper {

    public int solve(int A, int[] B) {

        int i = 0;
        while (A > 0) {
            i %= 7;
            A -= B[i++];
        }
        return i;
    }
}

