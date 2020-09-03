package com.zrandom;

import java.util.Arrays;

public class NextGreaterPermutation {


    public static void main(String[] args) {

        int[] arr = new int[]{7, 6, 5, 1, 3, 3, 1};
        int ans = nextGreaterPermut(arr);

        if (ans == -1) {
            System.out.println(-1);
        } else {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int nextGreaterPermut(int[] arr) { // [1,1,2,3]

        int index = -1;

        int currGreater = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < currGreater) {
                index = i;
                break;
            }
            currGreater = arr[i];
        }

        if (index == -1) {
            return -1;
        }

        // 1. find index where the ascending order breaks (iterating from the last), idx        -> O(n)
        // 2. from the index i found out above keep looking for its next greater digit (iterating from the last), idx1    -> O(n)
        // 3. now do the swap of the elements  idx and idx1         -> O(1)
        // 4. now sort the array from idx+1 till the last           -> O(n log(n))

        int index1 = -1;
        for (int i = arr.length - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                index1 = i;
                break;
            }
        }

        swap(arr, index, index1);

        reverseSubArray(arr, index + 1, arr.length - 1);

        return 0;
    }

    private static void swap(int[] A, int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }

    private static void reverseSubArray(int[] A, int idx1, int idx2) {

        while (idx1 < idx2) {
            swap(A, idx1, idx2);
            idx1++;
            idx2--;
        }
    }
}