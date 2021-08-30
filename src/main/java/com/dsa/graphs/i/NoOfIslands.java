package com.dsa.graphs.i;

public class NoOfIslands {

    private boolean[][] visited;
    //better way to handle allowed neighbours
    private int[] rows = new int[]{-1, 0, 1, 0, -1, 1, -1, 1};
    private int[] cols = new int[]{0, -1, 0, 1, -1, 1, 1, -1};

    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !visited[i][j]) { //do dfs on all 1's, separate islands will be counted
                    count++;
                    dfs(i, j, A);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] A) {
        visited[i][j] = true;
        for (int k = 0; k < rows.length; k++) { //go in all directions
            int nextI = i + rows[k];
            int nextJ = j + cols[k];
            //do dfs only if neighbour is 1
            if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length &&
                    !visited[nextI][nextJ] && A[nextI][nextJ] == 1) {
                dfs(nextI, nextJ, A);
            }
        }
    }
}

