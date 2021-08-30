package com.dsa.arraysNmath;

import java.util.Arrays;

public class MaxConsecutiveGap {

    public int maximumGap(final int[] A) {

        if (A.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        if (max == min) {
            return 0;
        }

        int bucketSize = (int) Math.ceil((double) (max - min) / (A.length - 1)); //taking ceil ensures bucketSize is never 0

        int[] bucketMin = new int[A.length];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        int[] bucketMax = new int[A.length];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int i = 0; i < A.length; i++) {

            int index = (A[i] - min) / bucketSize; // subtracting from min ensures index is never larger than the allocated size;
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
        return maxGap;
    }
}

