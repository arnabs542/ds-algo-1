package com.dsa.arrays;

public class SumOfAllSubmatrices {

    public int solve(int[][] A) {

        int ans = 0;
        int rows = A.length;
        int columns = A[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans += (i + 1) * (j + 1) * (rows - i) * (columns - j) * A[i][j];  //formula, for derivation refer class notes
            }
        }
        return ans;
    }
}

