package com.dsa.sorting.ii;

import java.util.Arrays;

public class UniqueElements {

    public int solve(int[] A) {

        Arrays.sort(A);
        int count = 0;

        for (int i = 1; i < A.length; i++) {

            int diff = A[i] - A[i - 1];

            if (diff == 0) { //current and previous elements are same
                A[i]++; //increment current element by 1
                count++; // # of steps++
            } else if (diff < 0) { //currElem < prevElem, currElem has to be increased to a no. greater than prevElem
                count += Math.abs(diff) + 1;
                A[i] += Math.abs(diff) + 1;
            }
        }
        return count;
    }
}

