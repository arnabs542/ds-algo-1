package com.dsa.arraysNmath;

public class MaxAbsDiff {

    public int maxArr(int[] A) {

        int maxPlus = Integer.MIN_VALUE;//max A[i] + i
        int minPlus = Integer.MAX_VALUE;//min A[i] + i

        int maxMinus = Integer.MIN_VALUE;//max A[i] - i
        int minMinus = Integer.MAX_VALUE;//min A[i] - i

        for (int i = 0; i < A.length; i++) {
            maxPlus = Math.max(maxPlus, A[i] + i);
            minPlus = Math.min(minPlus, A[i] + i);
            maxMinus = Math.max(maxMinus, A[i] - i);
            minMinus = Math.min(minMinus, A[i] - i);
            System.out.println();
        }

        return Math.max(maxPlus - minPlus, maxMinus - minMinus);
    }
}

