package com.dsa.sorting.i;

public class MaximumUnsortedSubarray {
    public int[] subUnsort(int[] A) {

        int leftIndex = -1;//index (including) till which array is sorted i.e from start -> leftIndex
        int rightIndex = -1;//index (including) till which array is sorted i.e from rightIndex -> last

        boolean flag = false;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, A[i]);
            }
        }

        flag = false;

        int max = Integer.MIN_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, A[i]);
            }
        }

        //need to start sorting from index whose value > min
        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                leftIndex = i;
                break;
            }
        }

        //need to end sorting at index whose value < max
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < max) {
                rightIndex = i;
                break;
            }
        }

        if (rightIndex - leftIndex <= 0) {
            return new int[]{-1};
        }
        return new int[]{leftIndex, rightIndex};
    }
}
