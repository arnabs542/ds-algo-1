package com.dsa.arraysNmath;

import java.util.Arrays;

public class NextPermutation {

    public int[] nextPermutation(int[] A) {

        int val = A[A.length - 1];
        int idx = -1;

        // determining idx by iterating from last till a point where ascending order is broken
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < val) {
                idx = i;
                break;
            }
            val = A[i];
        }

        if (idx == -1) {
            Arrays.sort(A);
            return A;
        }

        int idx1 = -1;

        // iterate from last to determine next higher number for A[idx]
        for (int i = A.length - 1; i >= idx + 1; i--) {
            if (A[i] > A[idx]) {
                idx1 = i;
                break;
            }
        }

        //swap elements A[idx] and A[idx1]
        swap(A, idx, idx1);

        //sort from idx+1 till last
        //Arrays.sort(A,idx+1,A.length);

        //Actually sorting not needed as all are in descending order, just swap and make them in ascending order
        swapAll(A, idx + 1, A.length - 1);
        return A;
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    private void swapAll(int[] A, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(A, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}


