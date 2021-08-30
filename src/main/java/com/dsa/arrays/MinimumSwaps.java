package com.dsa.arrays;

public class MinimumSwaps {

    public int solve(int[] A, int B) {

        if (A.length <= 2) {
            return 0;
        }
        int count = 0; //count of no.s <= B
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                count++;
            }
        }

        //sliding window technique is used because all no.s <= B when brought together will form length of the sliding window
        int a = 0; // count of no.s in 1st sliding window > B, final answer is min of count of no.s in all sliding windows
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                a++;
            }
        }

        int ans = a;
        //superb logic of sliding window in O(n)
        int i = 0;
        for (int j = count; j < A.length; i++, j++) {
            if (A[i] > B) { //ith element moving out of window
                a--;
            }
            if (A[j] > B) { //jth element coming into the window
                a++;
            }
            ans = Math.min(a, ans);
        }
        return ans;
    }
}
