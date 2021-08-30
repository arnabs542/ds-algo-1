package com.dsa.searching.ii;

public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {

        long l = 0;
        long r = 0;//has the sum of all elements in C, max time taken (occurs when only one painter is there)

        for (int i = 0; i < C.length; i++) {
            r += C[i];
        }

        long ans = 0;
        //binary search on the possible time takens
        while (l <= r) {
            long mid = l + ((r - l) / 2);

            //check if lesser time possible than mid time
            if (isLesserTimePossible(A, C, mid)) {
                r = mid - 1L;
                ans = mid;
            } else {
                l = mid + 1L;
            }
        }
        long a = (B) * (ans % 10000003);
        return (int) (a % 10000003);
    }

    private boolean isLesserTimePossible(int A, int[] C, long currTime) {

        int noOfsubArrays = 1;
        long totalTime = 0;

        for (int i = 0; i < C.length; i++) {
            if (C[i] > currTime) {//if one element not making it possible, summing with others also wont make it possible
                return false;
            }
            totalTime += C[i];//keep adding

            //if totalTime gets greater, increase noOfsubArrays because subarray till then was satisfying.
            //Now check again for next subarray, so reset total time to C[i]
            if (totalTime > currTime) {
                totalTime = C[i];
                noOfsubArrays++;
            }
        }

        return noOfsubArrays <= A; //possible only if no. of painters needed to make it possible are atmost A
    }
}
