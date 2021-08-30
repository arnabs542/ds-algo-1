package com.dsa.dp.ii;

public class UniquePathsGrid {

    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        if (A[n - 1][m - 1] == 1) { //if destination has obstacle, can't reach
            return 0;
        }
        int[][] dp = new int[2][m + 1]; //create one dummy column and row to avoid IndexOutOfBoundError
        dp[1][1] = 1; //dp[i][j] represents no. of ways to reach i-1,j-1 from 0,0 (in original array)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (i == 1 && j == 1)
                    continue;

                int temp = 0;
                if (j - 2 >= 0 && A[i - 1][j - 2] == 0) {  //can go somewhere only from empty space
                    temp = dp[i % 2][j - 1]; //can reach from left
                }
                if (i - 2 >= 0 && A[i - 2][j - 1] == 0) {  //can go somewhere only from empty space
                    temp += dp[(i - 1) % 2][j]; //can also reach from up, so add up
                }
                dp[i % 2][j] = temp;
            }
        }
        return dp[n % 2][m];
    }
}
