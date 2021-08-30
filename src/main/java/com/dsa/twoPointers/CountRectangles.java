package com.dsa.twoPointers;

public class CountRectangles {
    public int solve(int[] A, int B) {
        int mod = ((int) Math.pow(10, 9)) + 7;

        int ans = 0;
        int j = A.length - 1; //right pointer
        int i = 0; //left pointer

        //sliding window approach
        for (; i < A.length; i++) {
            //if area of A[i] and A[j] is not smaller than B, decrement right pointer
            while (j >= 0 && (Long.valueOf(A[i]) * Long.valueOf(A[j]) >= Long.valueOf(B))) {
                j--;
            }
            ans = (ans + j + 1) % mod; //between i and j, we have j+1 rectangles with area lesser than B
        }
        return ans;
    }
}
