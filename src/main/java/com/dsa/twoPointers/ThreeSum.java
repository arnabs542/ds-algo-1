package com.dsa.twoPointers;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {

        Arrays.sort(A);
        int ans = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int requiredSum = B - A[i]; //search for A[l] + A[r] that is closest to requiredSum

            int l = i + 1;
            int r = A.length - 1;

            //basic two pointer approach
            while (l < r) {
                if (min > Math.abs(requiredSum - A[l] - A[r])) { //update min and ans
                    min = Math.abs(requiredSum - A[l] - A[r]);
                    ans = A[l] + A[r] + A[i];
                }
                if (A[l] + A[r] > requiredSum) {
                    r--;
                } else if (A[l] + A[r] < requiredSum) {
                    l++;
                } else {
                    return A[l] + A[r] + A[i];
                }
            }
        }
        return ans;
    }
}
