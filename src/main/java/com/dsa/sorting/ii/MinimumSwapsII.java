package com.dsa.sorting.ii;

public class MinimumSwapsII {

    public int solve(int[] A) {
        //for cycle of size N, N-1 swaps are needed.
        boolean[] visited = new boolean[A.length]; //visited indexes
        int swaps = 0;

        for (int i = 0; i < A.length; i++) {

            if (i != A[i]) {//swap needed only if (i != A[i])
                visited[i] = true;
                int k = A[i];
                while (!visited[k]) {
                    visited[k] = true;
                    k = A[k];
                    swaps++;
                }
            }
        }
        return swaps;
    }
}

