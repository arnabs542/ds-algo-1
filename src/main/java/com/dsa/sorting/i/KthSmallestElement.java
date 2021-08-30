package com.dsa.sorting.i;

public class KthSmallestElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            l = Math.min(l, A[i]);
            r = Math.max(r, A[i]);
        }
        int ans = -1;
        //binary search
        while (l <= r) {

            int mid = l + ((r - l) / 2);
            int count = countLesserEqual(mid, A);

            if (count >= B) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int countLesserEqual(int k, int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= k) {
                count++;
            }
        }
        return count;
    }
}

