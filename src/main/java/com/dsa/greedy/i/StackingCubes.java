package com.dsa.greedy.i;

public class StackingCubes {
    public int solve(int A) {

        int count = 1; //for P=1
        //check pairs of factors
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                count += (A == i * i) ? 1 : 2; //for perfect square don't count twice as its the same pair
            }
        }
        return count;
    }
}

