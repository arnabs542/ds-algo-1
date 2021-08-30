package com.dsa.searching.i;

public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {

        int l = 0;
        int r = A.length - 1;

        int index = 0;
        //binary search to determine on which row element can be found
        //can be determined by checking just first column elements
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (A[mid][0] > B) {
                r = mid - 1;
            } else if (A[mid][0] < B) {
                l = mid + 1;
                index = mid;
            } else {
                return 1;
            }
        }

        int start = 0;
        int end = A[0].length - 1;
        //binary search to find element in row (found in previous step)
        while (start <= end) {
            int middle = start + ((end - start) / 2);

            if (A[index][middle] > B) {
                end = middle - 1;
            } else if (A[index][middle] < B) {
                start = middle + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}

