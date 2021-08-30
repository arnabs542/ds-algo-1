package com.dsa.dp.viii;

import java.util.HashMap;

public class FrogJump {

    private boolean[][] dp;

    public int solve(int[] A) {

        //value to index mapping
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        //dp[i][j] is true if possible to reach stone at index i with jumpSize j
        dp = new boolean[A.length][A.length];
        dp[1][1] = true; //possible to reach 2nd stone(index 1) with 1 jump, as stated in the question

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (i == 1 && j == 1) {
                    continue;
                }
                //with j-1 jumps from validStoneIndex we can reach i, so update dp[i][j - 1]
                int validStoneIndex = map.getOrDefault(A[i] - (j - 1), -1);
                if (validStoneIndex >= 0 && validStoneIndex < i) {
                    dp[i][j - 1] |= dp[validStoneIndex][j];
                }
                //with j+1 jumps from validStoneIndex we can reach i, so update dp[i][j + 1]
                validStoneIndex = map.getOrDefault(A[i] - (j + 1), -1);
                if (validStoneIndex >= 0 && validStoneIndex < i && j + 1 < A.length) {
                    dp[i][j + 1] |= dp[validStoneIndex][j];
                }
                //with j jumps from validStoneIndex we can reach i, so update dp[i][j]
                validStoneIndex = map.getOrDefault(A[i] - j, -1);
                if (validStoneIndex >= 0 && validStoneIndex < i) {
                    dp[i][j] |= dp[validStoneIndex][j];
                }
            }
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (dp[A.length - 1][i]) { //if possible to reach last stone with any jumpSize > 0
                return 1;
            }
        }
        return 0;
    }

//     private int[][] dp;

//     public int solve(int[] A) {

//         dp = new int[A.length + 1][A.length + 1]; //for memoization
//         for (int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return recurse(0, 1, A) ? 1 : 0;
//     }

//     public boolean recurse(int position, int jumpSize, int[] A) {

//         if (position == A[A.length - 1]) //if able to reach last stone
//             return true;

//         int index = Arrays.binarySearch(A, position);
//         if (jumpSize <= 0 || jumpSize >= A.length + 1 || index < 0) { //if position doesn't exist in the stone array
//             return false;
//         }

//         if (dp[index][jumpSize] != -1) {
//             return dp[index][jumpSize] == 1 ? true : false;
//         }

//         dp[index][jumpSize] = recurse(position + jumpSize - 1, jumpSize - 1, A)
//                 || recurse(position + jumpSize, jumpSize, A)
//                 || recurse(position + jumpSize + 1, jumpSize + 1, A) ? 1 : 0;

//         return dp[index][jumpSize] == 1 ? true : false;
//     }
}

