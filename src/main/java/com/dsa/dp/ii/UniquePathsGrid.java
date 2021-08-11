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
/*
Unique Paths in a Grid
Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.



Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1



Input Format
Firts and only argument A is a 2D array of size n * m.



Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).



Example Input
Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 So, the total number of unique paths is 2.
Explanation 2:

 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */