package com.dsa.twoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] A) {
        int ans = 0;
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int a = Math.min(A[l], A[r]); //take min among the two
            ans = Math.max(ans, (r - l) * a); //update max value, for 'a' (r-l)*a will be the max possible

            if (a == A[l]) { //if min was A[l], increment l
                l++;
            } else { //if min was A[r], decrement r
                r--;
            }
        }
        return ans;
    }
}

