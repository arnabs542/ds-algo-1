package com.dsa.sorting.i;

public class AlternatePositiveNegativeElements {
    public int[] solve(int[] A) {

        int j;
        for (int i = 0; i < A.length; i++) {
            j = i;
            if ((i % 2 == 0) && A[i] >= 0) {
                while (j < A.length && A[j] >= 0) {
                    j++;
                }
                rotateRight(i, j, A);
            } else if ((i % 2 == 1) && A[i] < 0) {
                while (j < A.length && A[j] < 0) {
                    j++;
                }
                rotateRight(i, j, A);
            }
        }
        return A;
    }

    //shifts elements towards right from i till j
    private void rotateRight(int i, int j, int[] A) {

        if (j == A.length) {
            return;
        }
        int requiredVal = A[j]; //value to be put at ith index
        for (int k = j; k > i; k--) {
            A[k] = A[k - 1];
        }
        A[i] = requiredVal; //put the value at ith index after shifting
    }
}

