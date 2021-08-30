package com.dsa.searching.i;

public class SingleElementInSortedArray {

    public int solve(int[] A) {

        //ans will always be at even index
        // arr -> 1 1 2 2 3 3 4 4 5 6 6  7  7  8  8
        // idx -> 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        int l = 0;
        int r = A.length - 1;

        int ans = 0;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            //even
            if (mid % 2 == 0) {
                if (mid != 0 && A[mid] == A[mid - 1]) {// mid != 0 to handle corner case,  can't go beyond 0 to the left
                    r = mid - 1; //take above example, it will be clear
                } else {
                    ans = mid;
                    l = mid + 1;
                }
            } else {//odd
                if (A[mid] == A[mid + 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return A[ans];
    }
}
