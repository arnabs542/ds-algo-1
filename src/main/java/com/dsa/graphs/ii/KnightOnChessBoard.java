package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class KnightOnChessBoard {

    public int knight(int A, int B, int C, int D, int E, int F) {

        if (C == E && D == F) {
            return 0;
        }

        int[] rows = new int[]{-2, -2, 1, 1, 2, 2, -1, -1};
        int[] cols = new int[]{-1, 1, 2, -2, -1, 1, 2, -2};

        boolean[][] visited = new boolean[A][B];

        //queue for doing BFS
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(C - 1, D - 1));
        visited[C - 1][D - 1] = true;

        int level = 0;
        int size = deque.size();

        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();
            size--;

            if (pair.i == E - 1 && pair.j == F - 1) {
                return level;
            }

            for (int k = 0; k < rows.length; k++) {

                int nexti = pair.i + rows[k];
                int nextj = pair.j + cols[k];

                if (nexti >= 0 && nexti < A && nextj >= 0 && nextj < B && !visited[nexti][nextj]) {
                    visited[nexti][nextj] = true;
                    deque.addLast(new Pair(nexti, nextj));
                }
            }
            if (size == 0 && !deque.isEmpty()) {
                level++;
                size = deque.size();
            }
        }
        return -1;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

/*
Knight On Chess Board
Problem Description

Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints
1 <= A, B <= 500



Input Format
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input
Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output
Output 1:

 6
Output 2:

 -1


Example Explanation
Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1)
 */