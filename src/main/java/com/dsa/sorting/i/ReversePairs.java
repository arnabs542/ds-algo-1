package com.dsa.sorting.i;

public class ReversePairs {
    private int[] sortedArray;
    private int count = 0;

    public int solve(int[] A) {
        sortedArray = new int[A.length];
        mergeSort(0, A.length - 1, A);

        return count;
    }

    private void mergeSort(int left, int right, int[] A) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) / 2);

        mergeSort(left, mid, A);
        mergeSort(mid + 1, right, A);
        merge(left, right, A);
    }

    private void merge(int left, int right, int[] A) {

        int aPtr = left;
        int mid = left + ((right - left) / 2);
        int bPtr = mid + 1;

        //for every element in 1st half that satisfies, determine no. of elements in 2nd half
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && A[i] / 2.0 > A[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int ansIdx = left;
        while (ansIdx <= right) {
            if ((aPtr <= mid) && (bPtr == right + 1 || A[aPtr] <= A[bPtr])) {
                sortedArray[ansIdx++] = A[aPtr++];
            } else if ((bPtr <= right) && (aPtr == mid + 1 || A[aPtr] > A[bPtr])) {
                sortedArray[ansIdx++] = A[bPtr++];
            }
        }
        //copy all elements of sortedArray back to original array, as it will be needed in subsequent recursions
        for (int i = left; i <= right; i++) {
            A[i] = sortedArray[i];
        }
    }
}

