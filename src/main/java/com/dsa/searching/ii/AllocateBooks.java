package com.dsa.searching.ii;

public class AllocateBooks {
    //same as Painter's partition problem
    public int books(int[] A, int B) {

        if (A.length < B) {
            return -1;
        }

        int l = 0;
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            r += A[i];
        }

        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (isAllocationPossible(A, B, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isAllocationPossible(int[] A, int B, int mid) {

        int noOfStudents = 1;
        int pages = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > mid) {
                return false;
            }
            pages += A[i];
            if (pages > mid) {
                pages = A[i];
                noOfStudents++;
            }
        }
        return noOfStudents <= B;//actual answer will occur for noOfStudents == B, we keep checking till we get such a mid value
    }
}
