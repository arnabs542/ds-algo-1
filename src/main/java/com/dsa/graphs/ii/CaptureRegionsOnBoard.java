package com.dsa.graphs.ii;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    private final int[] r = new int[]{-1, 0, 0, 1};
    private final int[] c = new int[]{0, -1, 1, 0};
    private boolean[][] visited;

    public void solve(ArrayList<ArrayList<Character>> a) {

        visited = new boolean[a.size()][a.get(0).size()];

        int[] rows = new int[]{a.size() - 1, 0};
        int[] cols = new int[]{a.get(0).size() - 1, 0};

        //do dfs on all 'O' on the boundary of 2D board, and mark all reachable 'O' as  '-'
        for (int k = 0; k < rows.length; k++) {

            int row = rows[k];
            for (int j = 0; j < a.get(0).size(); j++) {

                if (a.get(row).get(j) == 'O' && !visited[row][j]) {
                    visited[row][j] = true;

                    ArrayList<Character> ch = a.get(row);
                    ch.set(j, '-');
                    a.set(row, ch);

                    dfs(row, j, a);
                }
            }
        }

        //do dfs on all 'O' on the boundary of 2D board, and mark all reachable 'O' as  '-'
        for (int k = 0; k < rows.length; k++) {

            int col = cols[k];
            for (int i = 0; i < a.size(); i++) {

                if (a.get(i).get(col) == 'O' && !visited[i][col]) {
                    visited[i][col] = true;

                    ArrayList<Character> ch = a.get(i);
                    ch.set(col, '-');
                    a.set(i, ch);

                    dfs(i, col, a);
                }
            }
        }

        //now mark all '-' as 'O' and all 'O' as 'X'
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == '-') {
                    ArrayList<Character> ch = a.get(i);
                    ch.set(j, 'O');
                    a.set(i, ch);
                } else if (a.get(i).get(j) == 'O') {
                    ArrayList<Character> ch = a.get(i);
                    ch.set(j, 'X');
                    a.set(i, ch);
                }
            }
        }
    }

    public void dfs(int i, int j, ArrayList<ArrayList<Character>> a) {

        for (int k = 0; k < r.length; k++) {

            int nexti = i + r[k];
            int nextj = j + c[k];

            if (nexti >= 0 && nextj >= 0 && nexti < a.size() && nextj < a.get(0).size()
                    && !visited[nexti][nextj] && a.get(nexti).get(nextj) == 'O') {
                visited[nexti][nextj] = true;

                ArrayList<Character> ch = a.get(nexti);
                ch.set(nextj, '-');
                a.set(nexti, ch);

                dfs(nexti, nextj, a);
            }
        }
    }
}
/*
Capture Regions on Board
Problem Description

Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Problem Constraints
1 <= N, M <= 1000



Input Format
First and only argument is a N x M character matrix A.



Output Format
Make changes to the the input only as matrix is passed by reference.



Example Input
Input 1:

 A = [
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X]
     ]
Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Output
Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]
Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Explanation
Explanation 1:

 O in (4,2) is not surrounded by X from below.
Explanation 2:

 No O's are surrounded.

 */
