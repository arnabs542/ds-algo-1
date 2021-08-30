package com.dsa.twoPointers;

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

        int countofZeros = 0; //no. of zeros in the sliding window
        int maxSoFar = 0; //length of the largest sequence so far

        int start = -1; //index where the largest sequence starts
        int end = -1; //index where the largest sequence ends

        int j = 0; //left pointer of sliding window
        for (int i = 0; i < A.size(); i++) { //i is the right pointer of sliding window
            if (A.get(i) == 0) {
                countofZeros++;
            }
            while (countofZeros > B) {
                if (A.get(j) == 0) {
                    countofZeros--;
                }
                j++; //move left pointer towards right till countOfZeroes is not greater than B
            }
            if (maxSoFar < i - j + 1) { // update sliding window size and start/end indices
                maxSoFar = Math.max(maxSoFar, i - j + 1);
                end = i;
                start = j;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ans.add(i);
        }
        return ans;
    }
}
