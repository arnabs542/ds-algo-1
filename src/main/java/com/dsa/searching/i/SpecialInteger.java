package com.dsa.searching.i;

public class SpecialInteger {
    public int solve(int[] A, int B) {

        int l = 1;
        int r = A.length;

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (ifEachSumLessThanEqualsB(A, B, mid)) {//mid is window size, if each sum not greater then increase window size
                ans = mid;//this can be ans, but keep checking for higher value
                l = mid + 1;
            } else {//decrease window size
                r = mid - 1;
            }
        }
        return ans;
    }

    //checks all subarrays of size k and returns false if any subarray sum is greater than B
    private boolean ifEachSumLessThanEqualsB(int[] A, int B, int k) {

        long sum = 0L;
        for (int i = 0; i < k; i++) {
            sum += A[i];
        }
        if (sum > B) {
            return false;
        }
        for (int i = 0, j = k; j < A.length; i++, j++) {
            sum -= A[i];
            sum += A[j];

            if (sum > B) {
                return false;
            }
        }
        return true;
    }
}

