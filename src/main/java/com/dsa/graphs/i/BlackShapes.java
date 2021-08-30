package com.dsa.graphs.i;

public class BlackShapes {

    boolean[][] visited;
    //better way to handle allowed neighbours
    int[] rows = new int[]{-1, 0, 1, 0};
    int[] cols = new int[]{0, -1, 0, 1};

    public int black(String[] A) {

        int n = A.length;
        int m = A[0].length();

        visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visited[i][j]) { //do dfs on all X's, separate ones will be counted
                    count++;
                    dfs(i, j, A);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, String[] A) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) { //go in all directions
            int nextI = i + rows[k];
            int nextJ = j + cols[k];
            //do dfs only if neighbour is X
            if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length()
                    && !visited[nextI][nextJ] && A[nextI].charAt(nextJ) == 'X') {
                dfs(nextI, nextJ, A);
            }
        }
    }
}

