package com.arraysNmath;

import java.util.Arrays;

public class MaxConsecutiveGap {

    public int maximumGap(final int[] A) {

        if (A.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }

        if (max == min) {
            return 0;
        }

        float bucketSize = (float) (max - min) / (A.length - 1); //taking float ensures bucketSize is never 0

        int[] bucketMin = new int[A.length];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        int[] bucketMax = new int[A.length];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int i = 0; i < A.length; i++) {

            int index = Math.round((A[i] - min) / bucketSize); // subtracting from min ensures index is never larger than the allocated size;
            bucketMax[index] = Math.max(bucketMax[index], A[i]);
            bucketMin[index] = Math.min(bucketMin[index], A[i]);
        }

        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketMin.length; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) { // skip empty bucket
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return Math.max(maxGap, max - prevMax);
    }
}

/*
Problem Description

Given an unsorted integer array A of size N.
Find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Return 0 if the array contains less than 2 elements.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum difference.



Example Input
Input 1:

 A = [1, 10, 5]
Input 2:

 A = [10, 9, 10]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 After sorting, the array becomes [1, 5, 10]
 Maximum difference is (10 - 5) = 5.
Explanation 2:

 Maximum difference is (10 - 9) = 1.
 */