package com.dsa.searching.ii;

import java.util.Arrays;

public class AggressiveCows {
    public int solve(int[] A, int B) {

        Arrays.sort(A);//need to sort, to determine particular arrangement possibility
        int ans = 0;

        int l = 1;
        int r = A[A.length - 1] - A[0];

        //binary search from 1 -> MAX, check if mid distance separation is possible
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (isPossibleToArrange(A, B, mid)) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //checks if it is possible to arrange B cows with atleast dist separation btn any two cows
    private boolean isPossibleToArrange(int[] A, int B, int dist) {

        int cowsPlaced = 1;
        int lastPlacedIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[lastPlacedIndex] >= dist) {
                lastPlacedIndex = i;
                cowsPlaced++;
            }
        }
        return (cowsPlaced >= B) ? true : false;
    }
}
