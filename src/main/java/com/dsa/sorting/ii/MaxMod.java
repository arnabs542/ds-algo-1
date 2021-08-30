package com.dsa.sorting.ii;

public class MaxMod {

    public int solve(int[] A) {

        int secondLargest = -1;
        int largest = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > largest) {
                secondLargest = largest; //prev largest will be secondLargest
                largest = A[i];
            } else if (A[i] > secondLargest && A[i] < largest) { //if no. is between secondLargest and largest, update secondLargest
                secondLargest = A[i];
            }
        }
        return (secondLargest == -1) ? 0 : secondLargest; //secondLargest is -1 when all no.s are same
    }
}
