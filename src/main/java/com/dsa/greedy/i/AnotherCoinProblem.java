package com.dsa.greedy.i;

public class AnotherCoinProblem {

    public int solve(int A) {
        int count = 0;
        int r;

        while (A != 0) {
            r = (int) (Math.log(A) / Math.log(5)); //find max k, such that 5^k <= A
            A = A - (int) Math.pow(5, r); //update A with remaining amount
            count++;
        }
        return count;
    }
}

