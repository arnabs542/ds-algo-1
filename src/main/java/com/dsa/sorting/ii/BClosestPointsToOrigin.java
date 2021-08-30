package com.dsa.sorting.ii;

import java.util.Arrays;
import java.util.Comparator;

public class BClosestPointsToOrigin {

    public int[][] solve(int[][] A, int B) {

        Comparator<int[]> customComparator = (a, b) -> {
            Double distA = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
            Double distB = Math.sqrt(b[0] * b[0] + b[1] * b[1]);
            return distA.compareTo(distB);
        };
        Arrays.sort(A, customComparator);

        int[][] ans = new int[B][2];
        for (int i = 0; i < B; i++) {
            ans[i] = A[i];
        }
        return ans;
    }
}

