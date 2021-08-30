package com.dsa.arrays;

public class FirstMissingInteger {

    public int firstMissingPositive(int[] A) {

        // Answer condition is (1 <= Ans <= A.length + 1)
        // So put element at ith position at its right position, which is A[i]-1
        // After this operation array elements will be in sorted fashion, so in one more iteration we can find out first missing positive

        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 >= 0 && A[i] - 1 < A.length && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

