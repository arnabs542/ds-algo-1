package com.dsa.searching.i;

public class MatrixMedian {
    public int findMedian(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;
        int ans = -1;
        //binary search on [1, Integer.MAX_VALUE]
        int l = 1;
        int r = Integer.MAX_VALUE;

        int k = (rows * cols) / 2; //median is finding (k+1)th element
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            int lesser = lesserEqualCount(A, mid);

            if (lesser >= (k + 1)) {//can be median (when duplicates are present) or median is towards left
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    //total count of no.s <= mid in A
    private int lesserEqualCount(int[][] A, int mid) {
        int rows = A.length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            count += binarySearch(A[i], mid);
        }
        return count;
    }

    //returns the no. of elements in A s.t A[i] <= elem
    private int binarySearch(int[] A, int elem) {
        int l = 0;
        int r = A.length - 1;

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (A[mid] <= elem) {
                l = mid + 1;
                ans = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

